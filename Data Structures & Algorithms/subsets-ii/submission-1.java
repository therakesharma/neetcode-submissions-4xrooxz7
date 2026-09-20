class Solution {
    Set<List<Integer>> res = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        backtrack(nums, new ArrayList<>(), 0);
        return new ArrayList<>(res);
    }

    public void backtrack(int [] nums, List<Integer> curr, int i) {
        if (i == nums.length) {
            Collections.sort(curr);
            res.add(new ArrayList<>(curr));
            return;
        }
        if (i > nums.length) {
            return;
        }

        curr.add(nums[i]);
        backtrack(nums, curr, i + 1);

        curr.remove(Integer.valueOf(nums[i]));
        backtrack(nums, curr, i + 1);

    }
}
