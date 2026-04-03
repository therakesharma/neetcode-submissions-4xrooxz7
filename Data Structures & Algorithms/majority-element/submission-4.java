class Solution {
    public int majorityElement(int[] nums) {
        for (int num : nums) {
            int count = 0;
            for (int i = 0; i < nums.length; i++ ) {
                if (num == nums[i]) {
                    count++;
                }
            }
            if (count > nums.length / 2) {
                return num;
            }
        }
        return -1;
    }
}