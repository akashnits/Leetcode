class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // need to reach top floor i.e. dp[n+1]
        int n = cost.length -1;
        int dp[] = new int[n+2];
        // dp[i] -> min cost to reach ith step
        dp[0] = 0;
        dp[1] = 0;
        
        for(int i =2; i <= cost.length; i++){
            dp[i] = Math.min(dp[i-2] + cost[i-2], dp[i-1]+ cost[i-1]);
        }
        
        return dp[n+1];
    }
}
