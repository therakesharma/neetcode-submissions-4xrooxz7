class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length;) {
            int correctIndex = nums[i] - 1;

            if (nums[i] == nums[correctIndex] && i != correctIndex) {
                return nums[i];
            }

            if (nums[i] != nums[correctIndex]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }
        return -1;
    }
}