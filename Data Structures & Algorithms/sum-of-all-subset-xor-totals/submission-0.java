class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(0, nums, 0);
    }

    public int dfs(int index, int [] arr, int total) {
        if (index == arr.length) {
            return total;
        }

        return dfs(index + 1, arr, total ^ arr[index]) + dfs(index + 1, arr, total);
    }
}