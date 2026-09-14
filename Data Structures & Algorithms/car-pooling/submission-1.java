class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> Integer.compare(a[1], b[1]));

        int curr = 0;
        Queue<int []> minPQ = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int [] trip : trips) {
            int num = trip[0];
            int start = trip[1];

            while (!minPQ.isEmpty() && minPQ.peek()[2] <= start) {
                int [] top = minPQ.poll();
                curr -= top[0];
            }

            curr += num;
            if (curr > capacity) {
                return false;
            }

            minPQ.add(trip);
        }

        return true;
        
    }
}