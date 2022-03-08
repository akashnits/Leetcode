class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit =0;
        int lowest_buy = prices[0];
        
        for(int i=1; i < prices.length; i++){
            if(lowest_buy > prices[i]){
                // we buy
                lowest_buy = prices[i];
            }else{
                // we sell
                maxProfit = maxProfit + (prices[i] - lowest_buy);
                lowest_buy = prices[i];
            }
        }
        
        return maxProfit;
    }
}
