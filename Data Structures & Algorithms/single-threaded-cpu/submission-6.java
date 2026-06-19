class Solution {
    public int[] getOrder(int[][] tasks) {
        Queue<int[]> taskQueue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < tasks.length; i++) {
            int[] task = tasks[i];
            taskQueue.offer(new int[] { task[0], task[1], i });
        }

        int[] res = new int[tasks.length];
        int i = 0;
        long time = 0;

        while (!taskQueue.isEmpty()) {
            time = Math.max(time, taskQueue.peek()[0]);
            Queue<int[]> processingQueue = new PriorityQueue<>((a, b) -> {
                int cmp = Integer.compare(a[1], b[1]);
                if (cmp != 0) {
                    return cmp;
                }
                return Integer.compare(a[2], b[2]);
            });

            while (!taskQueue.isEmpty() && time >= taskQueue.peek()[0]) {
                processingQueue.offer(taskQueue.poll());
            }

            while (!processingQueue.isEmpty()) {
                int[] task = processingQueue.poll();
                res[i] = task[2];
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