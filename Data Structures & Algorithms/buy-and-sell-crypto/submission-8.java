class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = prices[0];
        for (int price : prices) {
            profit = Math.max(price - buy, profit);
            if (price < buy) {
                buy = price;
            }
        }
        return profit;
    }
}