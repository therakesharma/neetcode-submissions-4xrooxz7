class Solution {
    public int findDuplicate(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            int num = nums[index];
            int correctIndex = num - 1;
            if (correctIndex != index) {
                if (nums[correctIndex] == num) {
                    return num;
                } else {
                    nums[index] = nums[correctIndex];
                    nums[correctIndex] = num;
                }
            } else {
                index++;
            }
        }
        return -1;
        
    }
}