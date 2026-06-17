class KthLargest {
    Queue<Integer> minPQ = new PriorityQueue<>();
    int capacity;

    public KthLargest(int k, int[] nums) {
        capacity = k;
        for (int num : nums) {
            if (minPQ.size() == k && num < minPQ.peek()) {
                continue;
            }
            if (minPQ.size() == k) {
                minPQ.poll();
            }
            minPQ.offer(num);
        }
    }
    
    public int add(int val) {
        if (minPQ.isEmpty() || minPQ.size() < capacity) {
            minPQ.offer(val);
        } else if (val >= minPQ.peek()) {
            minPQ.poll();
            minPQ.offer(val);
        }
        
        return minPQ.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */