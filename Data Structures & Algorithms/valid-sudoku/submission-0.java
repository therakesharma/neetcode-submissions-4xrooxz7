class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            List<Character> rows = new ArrayList<>();
            List<Character> cols = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (rows.contains(board[i][j])) {
                        return false;
                    }
                    rows.add(board[i][j]);
                }
                if (board[j][i] != '.') {
                    if (cols.contains(board[j][i])) {
                        return false;
                    }
                    cols.add(board[j][i]);
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            List<Character> box = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    int row = j + (3 * (i / 3));
                    int col = k + (3 * (i % 3));
                    if (board[row][col] == '.') {
                        continue;
                    }
                    if (box.contains(board[row][col])) {
                        return false;
                    }
                    box.add(board[row][col]);
                }
            }
        }
        return true;
    }
}
