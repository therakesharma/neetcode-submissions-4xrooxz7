class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            int profit = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    profit = Math.max(profit, prices[j] - prices[i]);
                }
            }
            result = Math.max(result, profit);
        }
        return result;
    }
}
