class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result = Math.max(result, findArea(grid, 0, i, j));
                }
            }
        }
        return result;
    }
    
    public int findArea(int[][] grid, int area, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return area;
        }
        area = area + 1;
        grid[i][j] = 0;
        area = findArea(grid, area, i + 1, j);
        area = findArea(grid, area, i - 1, j);
        area = findArea(grid, area, i, j + 1);
        area = findArea(grid, area, i, j - 1);
        return area;
    }
}
