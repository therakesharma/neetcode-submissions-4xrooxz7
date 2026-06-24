class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int []> maxPQ = new PriorityQueue<>((a, b) -> {
            int disA = (a[0] * a[0]) + (a[1] * a[1]);
            int disB = (b[0] * b[0]) + (b[1] * b[1]);
            return Integer.compare(disB, disA);
        });

        for (int [] arr : points) {
            maxPQ.offer(new int[]{arr[0], arr[1]});
            if (maxPQ.size() > k) {
                maxPQ.poll();
            }
        }

        int[][] res = new int[maxPQ.size()][2];
        int i = 0;
        while(!maxPQ.isEmpty()) {
            res[i] = maxPQ.poll();
            i++;
        }

        return res;
        
    }
}