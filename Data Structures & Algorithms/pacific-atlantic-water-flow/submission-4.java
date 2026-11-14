class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        
        boolean[][] pacificVisited = new boolean[r][c];
        boolean[][] atlanticVisited = new boolean[r][c];

        
        for (int i = 0; i < c; i++) {
            upHill(0, i, heights[0][i], heights, pacificVisited);
            upHill(r - 1, i, heights[r - 1][i], heights, atlanticVisited);
        }
        for (int i = 0; i < r; i++) {
            upHill(i, 0, heights[i][0], heights, pacificVisited);
            upHill(i, c - 1, heights[i][c - 1], heights, atlanticVisited);
        }
        
    	List<List<Integer>> result = new ArrayList<>();
    	for (int i = 0; i < r; i++) {
    		for (int j = 0; j < c; j++) {
    			if (pacificVisited[i][j] && atlanticVisited[i][j]) {
    				result.add(List.of(i, j));
    			}
    		}
    	}
    	return result;
    }

    public void upHill(int i, int j, int prevHeight, int[][] heights, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= heights.length || j >= heights[0].length || heights[i][j] < prevHeight || visited[i][j]) {
        	return;
        }
        
        visited[i][j] = true;
        int currHeight = heights[i][j];
        
        upHill(i + 1, j, currHeight, heights, visited);
        upHill(i - 1, j, currHeight, heights, visited);
        upHill(i, j + 1, currHeight, heights, visited);
        upHill(i, j - 1, currHeight, heights, visited);    
    }
    
}
