class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int l = 0, r = 1;
        while(r < prices.length) {
            if (prices[r] < prices[l]) {
                l = r;
            }
            res = Math.max(prices[r] - prices[l], res);
            r++;
        }
        return res;
    }
}
