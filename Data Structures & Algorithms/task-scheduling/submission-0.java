class Solution {
    public int leastInterval(char[] tasks, int n) {
        int [] arr = new int[26];
        for (char task : tasks) {
            arr[task - 'A'] += 1;
        }

        Queue<Integer> maxPQTask = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : arr) {
            if (i > 0) {
                maxPQTask.offer(i);
            }
        }

        System.out.println("maxPQ -> " + maxPQTask.toString());

        Queue<int []> coolDownTask = new ArrayDeque<>();
        int time = 0;
        while (!maxPQTask.isEmpty() || !coolDownTask.isEmpty()) {
            time++;

            if (maxPQTask.isEmpty()) {
                time = coolDownTask.peek()[1];
            } else {
                int task = maxPQTask.poll() - 1;
                if (task > 0) {
                    coolDownTask.offer(new int[]{task, time + n});
                }
            }

            if (!coolDownTask.isEmpty() && coolDownTask.peek()[1] == time) {
                maxPQTask.offer(coolDownTask.poll()[0]);
            }

        }

        return time;
        
        
    }
}
