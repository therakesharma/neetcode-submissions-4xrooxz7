class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayList<>(), new int[nums.length]);
        return res;
    }

    public void backtrack(int[] nums, List<Integer> curr, int[] used) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }

            curr.add(nums[i]);
            used[i] = 1;

            backtrack(nums, curr, used);

            curr.remove(Integer.valueOf(nums[i]));
            used[i] = 0;
        }

    }
}
