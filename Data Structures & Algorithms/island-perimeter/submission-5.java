class Solution {
	Map<Integer, Boolean> visited;
    public int islandPerimeter(int[][] grid) {
    	visited = new HashMap<>();
    	int[] cords = getCords(grid);
        return dfs(grid, cords[0], cords[1], 0);
    }
    
    public int[] getCords(int[][] grid) {
    	for (int i = 0; i < grid.length; i++) {
    		for (int j = 0; j < grid[0].length; j++) {
    			if (grid[i][j] == 1) {
    				return new int[]{i, j};
    			}
    		}
    	}
        return null;
    }
    
    public int dfs(int[][] grid, int i, int j, int res) {
    	if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == 0) {
    		return res + 1;
    	}
    	if (visited.getOrDefault((i * grid[0].length) + j, false)) {
    		return res;
    	}
    	visited.put((i * grid[0].length) + j, true);
    	res = dfs(grid, i + 1, j, res);
    	res = dfs(grid, i - 1, j, res);
    	res = dfs(grid, i, j + 1, res);
    	res = dfs(grid, i, j - 1, res);
    	return res;
    }
}