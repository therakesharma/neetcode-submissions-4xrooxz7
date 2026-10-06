class Solution {
    private List<String> res;

    public List<String> wordBreak(String s, List<String> wordDict) {
        res = new ArrayList<>();
        backtrack(s, wordDict, new ArrayList<>(), 0, 0);
        return res;
    }

    public void backtrack(String s, List<String> wordDict, List<String> curr, int i, int j) {
        
        if (i == s.length()) {
            String str = String.join(" ", curr);

            if (!str.isEmpty()) {
                res.add(str);
            }
            
            return;
        }

        if (j >= s.length()) {
            return;
        }

        String str = s.substring(i, j + 1);        
        if (wordDict.contains(str)) {
            curr.add(str);
            backtrack(s, wordDict, curr, j + 1, j + 1);
            curr.remove(curr.size() - 1);
        }
        backtrack(s, wordDict, curr, i, j + 1);

    }
}