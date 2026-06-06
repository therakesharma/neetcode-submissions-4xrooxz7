class KthLargest {
    Queue<Integer> minPQ = new PriorityQueue<>();
    int cap;

    public KthLargest(int k, int[] nums) {
        cap = k;
        for (int i = 0; i < nums.length; i++) {
            if (minPQ.size() < cap) {
                minPQ.offer(nums[i]);
            } else if (minPQ.peek() < nums[i]) {
                minPQ.poll();
                minPQ.offer(nums[i]);
            }
        }
        
    }
    
    public int add(int val) {
        if (minPQ.size() < cap) {
            minPQ.offer(val);
        } else if (minPQ.peek() < val) {
            minPQ.poll();
            minPQ.offer(val);
        }
        return minPQ.peek(); 
    }
}
