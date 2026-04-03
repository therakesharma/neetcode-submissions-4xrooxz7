class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int result = 0;
        while (right < prices.length) {
            if (prices[right] > prices[left]) {
                result = Math.max(result, prices[right] - prices[left]);
                right++;
            } else {
                left = right;
                right += 1;
            }
        }
        return result;
    }
}
