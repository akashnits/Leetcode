class Solution {
    // idea: This is a problem of unbounded knapsack
    // create a 2D dp array whose cell represent the minimum number
    // of coins required to make amount j by using i coins
    
    // Imp: initialising first row with (amount+1) instead of Integer.MAX_VALUE-1 as     // number of coins can never be greater than given amount. Also, while returning     // the final result, if return value (min number of coins) is greater than           // amount, it means that the amount can't be made by given coins ( you may           // return -1 for this case); else return dp[n][amount]
    
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp= new int[n+1][amount+1];
        
        //initialize dp array
        for(int j =0 ; j < amount+1; j++){
            //can't make a amount with 0 coins
            //initializing this with number of coins = amount+1 ( not possible in reality), avoiding initlializing with Integer.MAX_VALUE to avoid overflow
            
            dp[0][j] = amount+1;
        }
        for(int i =0 ; i < n+1; i++){
            //only one way to make up amount 0, by not using any coin
            dp[i][0] = 0;
        }
        
        for(int i=1; i < n+1; i++){
            for(int j=1; j< amount+1; j++){
                if(coins[i-1] <= j){
                    //we can either take it or leave it
                   dp[i][j] =  Math.min(dp[i][j-coins[i-1]] + 1, dp[i-1][j]);
                }else{
                   dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount] > amount ? -1: dp[n][amount];
    }
}