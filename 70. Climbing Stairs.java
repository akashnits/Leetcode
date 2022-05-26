class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return numberWays(n, dp);
    }
    
    
    int numberWays(int n, int[] dp){
        // base condition
        if(n < 3){
            dp[n]=n;
            return n;
        }
        
        if(dp[n] != -1){
            return dp[n];
        }
        
        dp[n] = numberWays(n-1, dp) + numberWays(n-2, dp);
        return dp[n];
    }
}
