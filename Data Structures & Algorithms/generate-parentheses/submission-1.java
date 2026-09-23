class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(n, 0, 0, new StringBuilder());
        return res;
    }
    
    public void backtrack(int n, int open, int close, StringBuilder str) {
    	if (open > n || close > n || close > open) {
    		return;
    	}
    	if (str.length() == 2 * n) {
    		res.add(str.toString());
    		return;
    	}
    	
    	str.append('(');
    	backtrack(n, open + 1, close, str);
    	str.deleteCharAt(str.length() - 1);
    	
    	str.append(')');
    	backtrack(n, open, close + 1, str);
    	str.deleteCharAt(str.length() - 1);
    	
    }
}