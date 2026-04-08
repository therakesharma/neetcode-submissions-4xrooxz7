class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int prev = nums[0];
        if (prev > 1) {
            return 1;
        }
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            if (prev + 1 != nums[i] && prev != nums[i] && prev + 1 > 0) {
                return prev + 1;
            }
            if (prev <= 0 && nums[i] > 1) {
                return 1;
            }
            prev = nums[i];
        }
        if (prev < 1) {
            return 1;
        }
        return prev + 1;
    }
}