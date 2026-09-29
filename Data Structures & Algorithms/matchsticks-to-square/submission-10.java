
class Solution {
    public boolean makesquare(int[] m) {
        int n = m.length;
        if (n < 4) return false;

        int sum = 0;
        for (int x : m) sum += x;
        if (sum % 4 != 0) return false;

        int side = sum / 4;
        Arrays.sort(m);
        if (m[n - 1] > side) return false;

        return backtrack(m, new boolean[n], 0, 0, side, 4);
    }

    private boolean backtrack(int[] m, boolean[] used, int start,
                              int cur, int side, int sidesLeft) {
        // 3 sides are done, so the leftover sticks must make the 4th
        if (sidesLeft == 1) return true;

        // current side is complete, so start building the NEXT side
        if (cur == side) {
            return backtrack(m, used, 0, 0, side, sidesLeft - 1);
        }

        for (int i = start; i < m.length; i++) {
            if (used[i] || cur + m[i] > side) continue;

            used[i] = true;
            if (backtrack(m, used, i + 1, cur + m[i], side, sidesLeft)) {
                return true;
            }
            used[i] = false;                       // undo, try something else

            // same length as the stick that just failed, so it will fail too
            while (i + 1 < m.length && m[i + 1] == m[i]) i++;
        }
        return false;
    }
}