class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int [] res = new int[nums.length - k + 1];

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (!queue.isEmpty() && nums[right] >= nums[queue.peekLast()]) {
                queue.removeLast();
            }
            queue.add(right);
            while (!queue.isEmpty() && queue.peek() < left) {
                queue.remove();
            }
            if (right - left + 1 == k) {
                res[left] = nums[queue.peek()];
                left++;
            }
        }
        return res;
    }
}
