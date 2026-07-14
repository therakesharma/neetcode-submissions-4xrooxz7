class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(0, nums, target, 0, new ArrayList<>(), res);
        return res;
    }

    public void backtracking(int i, int[] nums, int target, int sum, List<Integer> subset, List<List<Integer>> res) {
        if (target == sum) {
            res.add(new ArrayList<>(subset));
            return;
        }
        if (i >= nums.length || sum >= target) {
            return;
        }
        subset.add(nums[i]);
        backtracking(i, nums, target, sum + nums[i], subset, res);
        sum -= nums[i];
        subset.remove(subset.size() - 1);
        backtracking(i + 1, nums, target, sum + nums[i], subset, res);
    }
}
