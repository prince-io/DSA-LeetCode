class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = 0;
        int profit = 0;

        for (int i = n-1; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            profit = Math.max(profit, max - prices[i]);
        }

        return profit;
    }
}