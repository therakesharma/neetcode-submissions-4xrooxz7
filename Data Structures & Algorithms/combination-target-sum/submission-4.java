class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(nums, new ArrayList<>(), target, 0, 0);
        return res;
    }

    public void backtrack(int [] nums, List<Integer> curr, int target, int sum, int index) {
        if (sum == target) {
            res.add(new ArrayList<>(curr));
        }
        if (sum >= target || index >= nums.length) {
            return;
        }
        

        curr.add(nums[index]);
        backtrack(nums, curr, target, sum + nums[index], index);

        curr.remove(Integer.valueOf(nums[index]));
        backtrack(nums, curr, target, sum, index + 1);

    }
}
