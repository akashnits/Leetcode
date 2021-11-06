class Solution {
    public int maxProfit(int[] prices) {
        int lowest_buying_price= prices[0];
        int profit =0;
        int max_profit =0;
        
        for(int i=1; i< prices.length; i++){
            //update lowest buying price if current price is lesser
            lowest_buying_price = Math.min(lowest_buying_price, prices[i]);
            
            //calculate profit
            profit = prices[i] - lowest_buying_price;
            
            //maximize profit
            max_profit = Math.max(max_profit, profit);
        }
        
        return max_profit;
    }
}
