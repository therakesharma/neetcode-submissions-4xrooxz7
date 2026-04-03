class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        int[] result = new int[nums.length];
        int pre = 1, post = 1;

        for (int i = 0; i < nums.length; i++) {
            pre *= nums[i];
            prefix[i] = pre;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            post *= nums[i];
            postfix[i] = post;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = i == 0 ? 1 : prefix[i-1];
            num *= i == nums.length - 1 ? 1 : postfix[i+1];
            result[i] = num;
        }
        return result;
    }
}  
