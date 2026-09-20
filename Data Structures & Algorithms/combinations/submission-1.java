class Solution {
    List<List<Integer>>  res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(k, n, 1, new ArrayList<>());
        return res;
    }

    public void backtrack(int k, int n, int index, List<Integer> curr) {
        
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (curr.size() > k || index > n) {
            return;
        }

        curr.add(index);
        backtrack(k, n, index + 1, curr);

        curr.remove(Integer.valueOf(index));
        backtrack(k, n, index + 1, curr);

    }
}