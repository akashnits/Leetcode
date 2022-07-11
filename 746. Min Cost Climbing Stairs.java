class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return Math.min(solve(cost, 0, dp), solve(cost, 1, dp));
    }
    
    
    int solve(int[] cost, int i, int[] dp) {
        // base condition
        if(i >= cost.length){
            return 0;
        }
        
        if(dp[i] != -1){
            return dp[i];
        }
        
        // choices - can climb 1 or 2 after paying up
        
        dp[i] =  cost[i]  + Math.min(solve(cost, i+1, dp), solve(cost, i+2, dp));
        return dp[i];
    }
}
