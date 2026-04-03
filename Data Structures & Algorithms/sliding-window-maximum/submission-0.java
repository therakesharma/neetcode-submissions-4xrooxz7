class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            result[i] = getMax(nums, i, i + k);
        }
        return result;
    }
    public int getMax(int[] nums, int start, int end) {
        int max = nums[start];
        for (int i = start + 1; i < end; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
