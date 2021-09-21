class Solution {
    //recursive approach
    
     public int numTrees(int n) {
        int sum=0;
        //base condition
        if( n <= 1){
            return 1;
        }
        
        for(int i=1; i <=n ; i++){
            sum += numTrees(i-1) * numTrees(n-i);
        }
        
        return sum;
    }
    
    // dp approach
    //here dp array contains the number of unique BST's which has exactly n nodes of unique values from 1 to n.
    
    public int numTrees(int n) {
        return solve(n , new int[n+1]);
    }
    
    int solve(int n, int[] dp){
        //base condition
        if( n <= 1){
            dp[n] =1;
            return 1;
        }
        
        for(int i=1; i <=n ; i++){
            dp[i-1] = dp[i-1] == 0 ? solve(i-1, dp): dp[i-1];
            dp[n-i] = dp[n-i] == 0 ? solve(n-i, dp): dp[n-i];
            dp[n] += dp[i-1] * dp[n-i];
        }
        
        return dp[n];
    }
}
