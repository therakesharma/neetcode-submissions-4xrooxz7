class Solution {
    public int[] getOrder(int[][] tasks) {
        Map<int [], Integer> indexTaskMap = new HashMap<>();
        Queue<int []> taskQueue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        for (int i = 0; i < tasks.length; i++) {
            int [] task = tasks[i];
            indexTaskMap.put(task, i);
            taskQueue.offer(task);
        }

        int [] res = new int[tasks.length];
        int i = 0;
        long time = 0;

        Queue<int []> processingQueue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        while (!taskQueue.isEmpty() || !processingQueue.isEmpty()) {
            time = Math.max(time, taskQueue.peek()[0]);
            while (!taskQueue.isEmpty() && time >= taskQueue.peek()[0]) {
                processingQueue.offer(taskQueue.poll());
            }

            while (!processingQueue.isEmpty()) {
                int [] task = processingQueue.poll();
                res[i] = indexTaskMap.get(task);
                time += task[1];
                i++;
                while (!taskQueue.isEmpty() && time >= taskQueue.peek()[0]) {
                    processingQueue.offer(taskQueue.poll());
                }
            }
        }

        return res;
        
    }
}