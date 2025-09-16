class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int MaxProfit = 0;
        for(int i =0; i < prices.length; i++) {
                int profit = prices[i] - buyPrice;
                MaxProfit = Math.max(MaxProfit,profit);
                buyPrice = Math.min(buyPrice, prices[i]);
        }
        return MaxProfit;
    }
}