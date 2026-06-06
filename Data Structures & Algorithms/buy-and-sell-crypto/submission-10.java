class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = prices[0];
        for (int price : prices) {
            if (price < buy) {
                buy = price;
            } else {
                profit = Math.max(price - buy, profit);
            }
        }
        return profit;
    }
}