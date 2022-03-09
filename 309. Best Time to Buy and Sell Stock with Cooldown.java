// State variables: 
// day; hold -> 1 if we have a share, else 0; 
// we have one more state variable called cooldown which as accounted for when we sell, we increased day by +2
class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return solve(prices, 0, 0, dp);
    }
    
    int solve(int[] prices, int day, int hold, int[][] dp){
        // base condition
        if(day >= prices.length)
            return 0;
        
        // choice diagram
        if(dp[day][hold] != -1){
            return dp[day][hold];
        }
        
        if(hold == 1){
            // we may sell
             dp[day][hold] = Math.max(prices[day] + solve(prices, day+2, 0, dp), solve(prices, day+1, hold, dp));
            return dp[day][hold];
        }else{
            // we may buy
             dp[day][hold] = Math.max(-prices[day] + solve(prices, day+1, 1, dp), solve(prices, day+1, hold, dp));
            return dp[day][hold];
        }
    }
}
