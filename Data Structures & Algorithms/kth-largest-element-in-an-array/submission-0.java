class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> minPQ = new PriorityQueue<>();
        for (int num : nums) {
            minPQ.offer(num);
            if (minPQ.size() > k) {
                minPQ.poll();
            } 
        }
        return minPQ.peek();
    }
}
