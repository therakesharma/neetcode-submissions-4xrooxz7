class Solution {
    public int maxProfit(int[] prices) {
        // Guard clause against empty arrays
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int maxProfit = 0;
        int minPrice = prices[0];

        // Start from index 1 to save micro-seconds
        for (int i = 1; i < prices.length; i++) {
            int currentPrice = prices[i];
            
            if (currentPrice < minPrice) {
                minPrice = currentPrice;
            } else {
                int currentProfit = currentPrice - minPrice;
                if (currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                }
            }
        }
        return maxProfit;
    }
}
