class Solution {
    Set<List<Integer>> res = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        backtrack(nums, new ArrayList<>(), new int[nums.length]);
        return new ArrayList<>(res);
    }

    public void backtrack(int[] nums, List<Integer> curr, int[] used) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (curr.size() > nums.length) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }

            curr.add(nums[i]);
            used[i] = 1;

            backtrack(nums, curr, used);

            curr.remove(curr.size() - 1);
            used[i] = 0;
        }
    }
}