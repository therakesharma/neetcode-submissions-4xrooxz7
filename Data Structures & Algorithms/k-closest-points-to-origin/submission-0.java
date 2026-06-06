class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if (k == points.length) {
            return points;
        }

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> {
            int d1 = a[0] * a[0] + a[1] * a[1];
            int d2 = b[0] * b[0] + b[1] * b[1];
            return d1 - d2;
        });

        int[][] result = new int[k][2];
        for (int [] arr : points) {
            queue.offer(arr);
        }

        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        return result;

    }
}
