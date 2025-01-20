/**
 * 시간복잡도 : O(n), 공간복잡도 : O(1)
 */

class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buyPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (buyPrice > prices[i]) {
                buyPrice = prices[i];
            }

            profit = Math.max(profit, buyPrice - prices[i]);
        }

        return profit;
    }
}
