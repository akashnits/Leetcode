class Solution {
    public int mincostTickets(int[] days, int[] costs) {
       int n = days.length;
       int[][] dp = new int[days[n-1]+30][n];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
       return solve(days, costs, 0, 0, dp); 
    }
    
    private int solve(int[] days, int[] costs, int validTill, int i, int[][] dp){
        // base condition        
        if(i == days.length){
            return 0;
        }
        
        if(dp[validTill][i] != -1){
            return dp[validTill][i];
        }
        
        // choice diagram - we either buy a ticket if expired or move ahead
        if(validTill < days[i]){
            // we buy a ticket
        dp[validTill][i] = Math.min(Math.min(costs[0] + solve(days, costs, days[i], i+1, dp), 
                                 costs[1] + solve(days, costs, days[i]+6, i+1, dp)), 
                                 costs[2] + solve(days, costs, days[i]+29, i+1,dp));
        }else{
            // we move ahead without buying
            dp[validTill][i] =  solve(days, costs, validTill, i+1, dp);
        }
        return dp[validTill][i];
    }
}
