class Solution {
    int res = 0;
    public int totalNQueens(int n) {
        backtracking(n, new boolean[n], new boolean[2 * n], new boolean[2 * n], 0);
        return res;
    }

    public void backtracking(int n, boolean[] used, boolean[] pos, boolean[] neg, int i) {
        if (i == n) {
            res += 1;
            return;
        }
        if (i >= n) {
            return;
        }

        for (int j = 0; j < n; j++) {
            int p = i + j;
            int q = i - j + n - 1;
            if (used[j] || pos[p] || neg[q]) {
                continue;
            }
            used[j] = pos[p] = neg[q] = true;
            backtracking(n, used, pos, neg, i + 1);
            used[j] = pos[p] = neg[q] = false;
        }
    }
}