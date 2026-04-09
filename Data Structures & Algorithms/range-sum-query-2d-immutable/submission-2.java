class NumMatrix {
    int [][] nums;

    public NumMatrix(int[][] matrix) {
        nums = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int topLeft = (i > 0 && j > 0) ? nums[i - 1][j - 1] : 0;
                int top = (i > 0) ? nums[i - 1][j] : 0;
                int left = (j > 0) ? nums[i][j - 1] : 0;
                nums[i][j] = matrix[i][j] + top + left - topLeft;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int topLeft = (row1 > 0 && col1 > 0) ? nums[row1 - 1][col1 - 1] : 0;
        int top = (row1 > 0) ? nums[row1 - 1][col2] : 0;
        int left = (col1 > 0) ? nums[row2][col1 - 1] : 0;
        return nums[row2][col2] - top - left + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */