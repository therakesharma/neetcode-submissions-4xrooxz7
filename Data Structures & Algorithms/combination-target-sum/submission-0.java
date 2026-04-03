class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        getSumList(0, nums, new ArrayList<>(), 0, target);
        return res;
    }

    public void getSumList(int i, int [] nums, List<Integer> curr, int total, int target) {
        if (total == target) {
            res.add(List.copyOf(curr));
            return;
        }
        if (total > target || i >= nums.length) {
            return;
        }
        curr.add(nums[i]);
        getSumList(i, nums, curr, total + nums[i], target);
        curr.remove(Integer.valueOf(nums[i]));
        getSumList(i + 1, nums, curr, total, target);
    }
}
