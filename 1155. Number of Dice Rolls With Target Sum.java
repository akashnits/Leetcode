class Solution {
    int mod=(int)(Math.pow(10,9))+7;
    public int numRollsToTarget(int n, int k, int target) {
        // backtracking approach with memo
        int[][] dp = new int[n+1][target+1];
        
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return solve(n, k, target, dp);
    }
    
    private int solve(int n, int k, int target, int[][] dp){
        
        //base condition
        // number of rolls and target - both equals zero
        if(target == 0 && n == 0){
            return 1;
        }
        
        // either one of number of rolls and target equals zero
        if(target == 0 || n == 0){
            return 0;
        }
        
        if(dp[n][target] != -1){
            return dp[n][target];
        }
        
        // choices
        int result =0; // we reset result every function call
        for(int i=1; i <= k; i++){
            if(i <= target){
                dp[n][target] =  ((result % mod) + solve(n-1, k, target-i, dp) % mod) % mod;
                result = dp[n][target];
            }
        }
        
        return result;
        
    }
}
