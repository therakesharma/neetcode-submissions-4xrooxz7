class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums, new ArrayList<>());
        return res;
    }

    public void backtrack(int index, int [] nums, List<Integer> curr) {
        if (index == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[index]);
        backtrack(index + 1, nums, curr);
        curr.remove(Integer.valueOf(nums[index]));
        backtrack(index + 1, nums, curr);

    }
}
