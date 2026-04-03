class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backTrack(list, "", 0, 0, n);
        return list;
    }

    public void backTrack(List<String> result,String curr,int open,int close,int n) {
        if (curr.length() == n*2) {
            result.add(curr);
            return;
        }
        if (open < n) {
            backTrack(result, curr + "(", open + 1, close, n);
        }
        if (close < open) {
            backTrack(result, curr + ")", open, close + 1, n);
        }
    }
}
