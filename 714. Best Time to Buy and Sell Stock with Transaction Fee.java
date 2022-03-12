class Solution {
    // state variable: i -> day; hold -> 0,1 (if we have a share)
    
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return solve(prices, 0, 0, fee, dp);
    }
    
    
    private int solve(int[] prices, int i, int hold, int fee, int[][] dp){
        
        // base condition
        if( i == prices.length){
            return 0;
        }
        
        if(dp[i][hold] != -1){
            return dp[i][hold];
        }
        
        // choice diagram
        if(hold ==1){
            // we may/may not sell
            dp[i][hold] =  Math.max(prices[i] - fee + solve(prices, i+1, 0, fee, dp),                                 solve(prices, i+1, hold, fee, dp));
        }else{
            // we may/may not buy depending on price
            dp[i][hold] =  Math.max(-prices[i] + solve(prices, i+1, 1, fee, dp),                                        solve(prices, i+1, hold, fee, dp));
        }
        return dp[i][hold];
    }
}
