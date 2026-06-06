class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int num : piles) {
            max = Math.max(max, num);
        }
        int minSpeed = 0;
        int left = 1, right = max;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long time = eatingTime(piles, mid);
            if (time <= h) {
                right = mid - 1;
                minSpeed = mid;
            } else {
                left = mid + 1;
            }
        }
        return minSpeed;
    }

    public long eatingTime(int[] piles, int speed) {
        long time = 0;
        for (int banana : piles) {
            time += (long) ((banana + speed - 1L) / speed);
        }
        return time;
    }
}
