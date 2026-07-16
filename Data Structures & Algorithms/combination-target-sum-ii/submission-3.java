class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res =  new ArrayList<>();
        backtracking(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    public void backtracking(int [] candidates, int target, int pos, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
        }
        if (target <= 0 || pos >= candidates.length) {
            return;
        }

        for (int index = pos; index < candidates.length; index++) {
            if (index > pos && candidates[index] == candidates[index - 1]) {
                continue;
            }
            curr.add(candidates[index]);
            backtracking(candidates, target - candidates[index], index + 1, curr, res);
            curr.remove(curr.size() - 1);
        }
        
    }
}