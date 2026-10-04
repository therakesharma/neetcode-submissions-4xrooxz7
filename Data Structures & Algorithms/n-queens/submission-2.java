class Solution {
    private List<List<String>> res = new ArrayList<>();
    private int[] queens;          // queens[row] = column
    private boolean[] cols;        // column occupied
    private boolean[] diag1;       // r + c  (anti-diagonal "/")
    private boolean[] diag2;       // r - c + n - 1  (diagonal "\")

    public List<List<String>> solveNQueens(int n) {
        queens = new int[n];
        cols = new boolean[n];
        diag1 = new boolean[2 * n - 1];
        diag2 = new boolean[2 * n - 1];
        backtrack(n, 0);
        return res;
    }

    private void backtrack(int n, int row) {
        if (row == n) {
            res.add(format(n));
            return;
        }
        for (int c = 0; c < n; c++) {
            int d1 = row + c;
            int d2 = row - c + n - 1;
            if (cols[c] || diag1[d1] || diag2[d2]) continue;

            queens[row] = c;
            cols[c] = diag1[d1] = diag2[d2] = true;
            backtrack(n, row + 1);
            cols[c] = diag1[d1] = diag2[d2] = false;
        }
    }

    private List<String> format(int n) {
        List<String> board = new ArrayList<>(n);
        char[] line = new char[n];
        for (int r = 0; r < n; r++) {
            Arrays.fill(line, '.');
            line[queens[r]] = 'Q';
            board.add(new String(line));
        }
        return board;
    }
}