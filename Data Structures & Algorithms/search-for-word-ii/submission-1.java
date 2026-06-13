class Solution {
    List<String> res = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            boolean found = false;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0) && search(board, word, i, j, 0)) {
                        res.add(word);
                        found = true;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }
        }
        return res;
    }

    public boolean search(char[][] board, String word, int i, int j, int n) {
        if (word.length() == n) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(n)) {
            return false;
        }
        char temp = board[i][j];

        board[i][j] = '#';

        boolean result = search(board, word, i + 1, j, n + 1)
        || search(board, word, i - 1, j, n + 1)
        || search(board, word, i, j - 1, n + 1)
        || search(board, word, i, j + 1, n + 1);

        board[i][j] = temp;

        return result;
    }
}
