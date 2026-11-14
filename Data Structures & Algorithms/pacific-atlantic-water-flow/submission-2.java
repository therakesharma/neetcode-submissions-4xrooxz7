class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        
        boolean[][] pVisited = new boolean[r][c];
        Set<Integer> pReachable = new HashSet<>();
        for (int i = 0; i < c; i++) {
            waterFlow(0, i, heights[0][i], heights, pVisited, pReachable);
        }
        for (int i = 0; i < r; i++) {
            waterFlow(i, 0, heights[i][0], heights, pVisited, pReachable);
        }
        
        boolean[][] aVisited = new boolean[r][c];
        Set<Integer> aRechable = new HashSet<>();
         for (int i = 0; i < c; i++) {
            waterFlow(r - 1, i, heights[r - 1][i], heights, aVisited, aRechable);
        }
        for (int i = 0; i < r; i++) {
            waterFlow(i, c - 1, heights[i][c - 1], heights, aVisited, aRechable);
        }
        
    	
    	List<List<Integer>> result = new ArrayList<>();
    	for (int index : pReachable) {
    	    if (aRechable.contains(index)) {
    	        result.add(new ArrayList(List.of(index / c, index % c)));
    	    }
    	}
    	return result;
    }

    public void waterFlow(int i, int j, int curr, int[][] heights, boolean[][] visited, Set<Integer> res) {
        if (i < 0 || j < 0 || i >= heights.length || j >= heights[0].length || heights[i][j] < curr || visited[i][j] == true) {
        	return;
        }
        
        visited[i][j] = true;
        res.add(i * heights[0].length + j);
        curr = heights[i][j];
        
        waterFlow(i + 1, j, curr, heights, visited, res);
        waterFlow(i - 1, j, curr, heights, visited, res);
        waterFlow(i, j + 1, curr, heights, visited, res);
        waterFlow(i, j - 1, curr, heights, visited, res);    
    }
    
}
