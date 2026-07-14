class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(0, nums, new ArrayList<>());
        return result;
    }

    public void backtracking(int i, int [] nums, List<Integer> subset) {
        if (i == nums.length) {
            //System.out.println("subset -> " + subset.toString());
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        backtracking(i + 1, nums, subset);

        subset.remove(subset.size() - 1);
        backtracking(i + 1, nums, subset);
    }
}
