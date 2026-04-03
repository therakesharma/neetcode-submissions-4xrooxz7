class Solution {
    private int count = 0;
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int len = row * column;
        for (int i = 0; i < row * column; i++) {
            int rIndex = i / column;
            int cIndex = i % column;
            if (grid[rIndex][cIndex] == '1') {
                count++;
                backTrack(grid, rIndex, cIndex);
            }
        } 
        return count;
    }

    public void backTrack(char[][] grid, int row, int column) {
        if (row >= grid.length || row < 0 || column >= grid[0].length || column < 0 || grid[row][column] == '0') {
            return;
        }
        grid[row][column] = '0';
        backTrack(grid, row + 1, column);
        backTrack(grid, row - 1, column);
        backTrack(grid, row, column + 1);
        backTrack(grid, row, column - 1);
    }
}
