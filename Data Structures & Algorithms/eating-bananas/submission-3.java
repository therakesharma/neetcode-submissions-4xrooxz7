class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = Arrays.stream(piles).max().getAsInt();
        int res = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long hrs = eatHours(piles, mid);

            if (hrs > h) {
                low = mid + 1;
            } else {
                res = mid;
                high = mid - 1;
            }
        }
        return res;
    }

    public long eatHours(int[] piles, int rate) {
        long res = 0;

        for (int num : piles) {
            res += (num + rate - 1) / rate;
        }
        return res; 
    }
}