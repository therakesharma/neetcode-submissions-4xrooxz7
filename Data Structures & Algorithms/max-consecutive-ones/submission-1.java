class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int curr = 0, max = 0;
        for (int num : nums) {
            if (num == 0) {
                max = Math.max(curr, max);
                curr = 0;
            } else {
                curr++;
            }
            
        }
        return Math.max(curr, max);
    }
}