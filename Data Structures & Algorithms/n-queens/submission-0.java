class Solution {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        backtrack(n, new ArrayList<>(), new int[n][n], 0);
        return res;
    }

    public void backtrack(int n, List<Integer> curr, int[][] used, int i) {
        if (curr.size() == n) {
            List<String> strs = format(curr, n);
            res.add(strs);
            return;
        }
        if (i >= n) {
            return;
        }

        for (int j = 0; j < n; j++) {
        	if (used[i][j] == 1) {
        		continue;
        	}
        	
        	if (isAvailable(curr, used, i, j)) {
        		used[i][j] = 1;
        		curr.add(j);
        		backtrack(n, curr, used, i + 1);
        		used[i][j] = 0;
        		curr.remove(curr.size() - 1); 
        	}
        }

    }
    
    public boolean isAvailable(List<Integer> curr, int[][] used, int i, int j) {
    	for (int r = 0; r < curr.size(); r++) {
            if (curr.get(r) == j || Math.abs(r - i) == Math.abs(curr.get(r) -   j)) {
                return false;
            }
        }
    	return true;
    }

    public List<String> format(List<Integer> curr, int n) {
        List<String> res = new ArrayList<>();

        for (int num : curr) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i == num) {
                    str.append('Q');
                } else {
                    str.append('.');
                }
            }
            res.add(str.toString());
        }

        return res;
    }
}
