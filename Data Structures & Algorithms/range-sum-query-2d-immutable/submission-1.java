class NumMatrix {
    int [][] nums;

    public NumMatrix(int[][] matrix) {
        nums = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int sum = matrix[i][j];
                int ci = i - 1, cj = j - 1;
                if (ci >= 0 && cj >= 0) {
                    sum -= nums[ci][cj];
                }
                int ai = i - 1, aj = j;
                if (ai >= 0 && aj >= 0) {
                    sum += nums[ai][aj];
                }
                int li = i, lj = j - 1;
                if (li >= 0 && lj >= 0) {
                    sum += nums[li][lj];
                }
                nums[i][j] = sum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = nums[row2][col2];
        int li = row2, lj = col1 - 1;
        if (li >= 0 && lj >= 0) {
            sum -= nums[li][lj];
        }
        int ai = row1 - 1, aj = col2;
        if ( ai >= 0 && aj >= 0) {
            sum -= nums[ai][aj];
        }
        int ci = row1 - 1, cj = col1 - 1;
        if (ci >= 0 && cj >= 0) {
            sum += nums[ci][cj];
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */