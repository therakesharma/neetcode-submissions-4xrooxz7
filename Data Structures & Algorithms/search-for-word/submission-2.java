class Solution {
    public boolean exist(char[][] board, String word) {
        boolean result = false;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (dfs(board, word, r, c, 0)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public boolean dfs(char[][] board, String word, int row, int column, int len) {
        if (len == word.length()) {
            return true;
        }
        if (row >= board.length || row < 0 || 
        column >= board[0].length || column < 0 ||
        board[row][column] != word.charAt(len)
        ) {
            return false;
        }
        char temp = board[row][column];
        board[row][column] = '#';

        boolean result = dfs(board, word, row + 1, column, len + 1) 
        || dfs(board, word, row - 1, column, len + 1) 
        ||  dfs(board, word, row, column + 1, len + 1) 
        || dfs(board, word, row, column - 1, len + 1);

        board[row][column] = temp;
        return result;
    }
}
