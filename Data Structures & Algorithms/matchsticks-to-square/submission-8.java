class Solution {

    public boolean makesquare(int[] matchsticks) {

        int sum = 0;

        for (int n : matchsticks) {
            sum += n;
        }

        if (sum % 4 != 0) {
            return false;
        }

        int target = sum / 4;

        // Largest sticks first
        Arrays.sort(matchsticks);

        // If largest stick itself is bigger than a side
        if (matchsticks[matchsticks.length - 1] > target) {
            return false;
        }

        int[] sides = new int[4];

        return backtrack(matchsticks, matchsticks.length - 1, sides, target);
    }

    private boolean backtrack(
        int[] matchsticks,
        int index,
        int[] sides,
        int target
    ) {

        // All matchsticks placed
        if (index < 0) {
            return sides[0] == target
                && sides[1] == target
                && sides[2] == target
                && sides[3] == target;
        }

        int stick = matchsticks[index];

        for (int i = 0; i < 4; i++) {

            // Don't exceed target
            if (sides[i] + stick > target) {
                continue;
            }

            // Put stick on this side
            sides[i] += stick;

            if (backtrack(matchsticks, index - 1, sides, target)) {
                return true;
            }

            // Undo
            sides[i] -= stick;

            // Important optimization:
            // If this stick couldn't work on an empty side,
            // don't try the other empty sides.
            if (sides[i] == 0) {
                break;
            }
        }

        return false;
    }
}