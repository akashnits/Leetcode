// Recursive approach
// State varaibles: 
// day , k -> transactionsRemaining, hold -> represents if we holding a share 
class Solution {
    public int maxProfit(int k, int[] prices) {
        return solve(prices, 0, k, 0);
    }
    
    private int solve(int[] prices, int day, int k, int hold){
        // base condition
        if( day == prices.length || k == 0){
            return 0;
        }
        
        // choice diagram
        // we may sell if we hold a stock i.e. hold == 1
        if( hold == 1){
            return Math.max(prices[day] + solve(prices, day+1, k-1, 0) ,
                           solve(prices, day+1, k, hold));
        }else{
            // we may buy if hold == 0
            return Math.max(-prices[day] + solve(prices, day+1, k, 1), 
                           solve(prices, day+1, k, hold));
        }
    }
}

// top-down approach
class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length][k+1][2];
        for(int[][] matrix: dp){
            for(int[] row: matrix){
                Arrays.fill(row, -1);
            }
        }
        return solve(prices, 0, k, 0, dp);
    }
    
    private int solve(int[] prices, int day, int k, int hold, int[][][] dp){
        // base condition
        if( day == prices.length || k == 0){
            return 0;
        }
        if(dp[day][k][hold] != -1){
            return dp[day][k][hold];
        }
        
        // choice diagram
        // we may sell if we hold a stock i.e. hold == 1
        if( hold == 1){
             dp[day][k][hold]= Math.max(prices[day] + 
                                        solve(prices, day+1, k-1, 0, dp) ,
                                        solve(prices, day+1, k, hold, dp));
            return dp[day][k][hold];
        }else{
            // we may buy if hold == 0
            dp[day][k][hold]= Math.max(-prices[day] + 
                                       solve(prices, day+1, k, 1, dp), 
                                       solve(prices, day+1, k, hold, dp));
            return dp[day][k][hold];
        }
    }
}
