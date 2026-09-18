class Solution {
    int sum = 0;
    public int subsetXORSum(int[] nums) {
        backtrack(0, nums, 0);
        return sum;
    }

    public void backtrack(int index, int [] nums, int total) {
        if (index == nums.length) {
            sum += total;
            return;
        }

        backtrack(index + 1, nums, nums[index] ^ total);
        backtrack(index + 1, nums, total);
    }

}