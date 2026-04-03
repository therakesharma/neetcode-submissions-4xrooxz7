class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                temp = 1;
            } else {
                if (nums[i] - nums[i - 1] == 1) {
                    temp++;
                } else if (nums[i] - nums[i - 1] > 1) {
                    temp = 1;
                }
            }
            if (temp > result) {
                result = temp;
            }
        }
        return result;
    }
}
