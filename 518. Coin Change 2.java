class Solution {
    //idea: The question is of unbounded knapsack.
    //we gonna construct a table of size (n+1 * amount+1), 
    //initializing first row and column
    // a cell in the table tells the number of ways that amount - j can be made
    // by using those i coins
    
    public int change(int amount, int[] coins) {
        int n= coins.length;
        
        int[][] dp = new int[n+1][amount+1];
        
        //initializing the dp table
        for(int j =0 ; j < amount+1; j++){
            //can't make a amount with 0 coins
            dp[0][j] = 0;
        }
        for(int i =0 ; i < n+1; i++){
            //only one way to make up amount 0, by not using any coin
            dp[i][0] = 1;
        }
        
        //for unbounded knapsack, we have two choices
        // 1. select - if we select, we can reuse that coin, hence we wouldn't decrement i
        // 2. reject - if we reject, we can't use that coin, so we decrement i
        for(int i= 1; i < n+1; i ++){
            for(int j=1; j < amount +1; j++){
                if(coins[i-1] <= j){
                    //we can either choose or reject
                    //we add up our choices since we need to find all the
                    //ways with which that amount could be made
                    
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                    
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }
    
    
    
    
}