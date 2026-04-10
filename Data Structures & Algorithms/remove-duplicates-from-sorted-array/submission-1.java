class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else if (j - 1 > i) {
                nums[i+1] = nums[j];
                i++;
            } else {
                i++;
                j++;
            }
        }
        return i + 1;
    }
}