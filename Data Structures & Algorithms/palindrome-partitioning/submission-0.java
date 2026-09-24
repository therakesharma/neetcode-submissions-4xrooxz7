class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, new ArrayList<>(), 0);
        return res;
    }

    public void backtrack(String s, List<String> curr, int i) {
        if (i == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int j = i; j < s.length(); j++) {
        	String str = s.substring(i, j + 1);
        	if (isPalindrome(s, i, j)) {
        		curr.add(str);
        		backtrack(s, curr, j + 1);
        		curr.remove(curr.size() - 1);
        	}
        }
    }
    
    public boolean isPalindrome(String s, int i, int j) {
    	while (i <= j) {
    		if (s.charAt(i) != s.charAt(j)) {
    			return false;
    		}
    		i++;
    		j--;
    	}
    	return true;
    }
}
