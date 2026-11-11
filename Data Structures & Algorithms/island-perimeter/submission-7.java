class Solution {
    public int islandPerimeter(int[][] grid) {
    	for (int i = 0; i < grid.length; i++) {
    		for (int j = 0; j < grid[0].length; j++) {
    			if (grid[i][j] == 1) {
    				return getPerimeter(grid, i, j, 0);
    			}
    		}
    	}
    	return -1;
    }
    
    public int getPerimeter(int[][] grid, int i, int j, int perimeter) {
    	if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
    		return perimeter + 1;
    	}
    	if (grid[i][j] == -1) {
    		return perimeter;
    	}
    	
    	grid[i][j] = -1;
    	perimeter = getPerimeter(grid, i + 1, j, perimeter);
    	perimeter = getPerimeter(grid, i - 1, j, perimeter);
    	perimeter = getPerimeter(grid, i, j + 1, perimeter);
    	return getPerimeter(grid, i, j - 1, perimeter);
    }
}