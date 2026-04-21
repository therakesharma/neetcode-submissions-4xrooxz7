class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            int buy = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                res = Math.max(prices[j] - buy, res);
            }
        }
        return res;
    }
}
