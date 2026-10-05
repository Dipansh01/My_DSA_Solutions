class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buyCost = prices[0];
        for(int i=1;i<prices.length;i++){
            int currProfit = prices[i] - buyCost;
            profit = Math.max(profit, currProfit);
            buyCost = Math.min(buyCost, prices[i]);
        }
        return profit;
    }
}