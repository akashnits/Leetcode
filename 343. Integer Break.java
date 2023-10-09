class Solution {
    // DP approach
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        if(n <= 3){
            return n-1;
        }
        return solve(n, dp);
    }


    int solve(int n, int[] dp){
        if( n <= 3){
            return n;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int res = n-1; // we can split the number as (1, n-1)
        // choices we have to split the integer
        for(int i=2; i < n; i++){
            // if we split: i * solve(n-i)
            dp[n] = Math.max(res, i * solve(n-i, dp));
            res = dp[n];
        }
        return dp[n] = res;
    }
}

class Solution {
    // Mathmatically, we need to use as many 3's as possible
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        
        int ans = 1;
        while (n > 4) {
            ans *= 3;
            n -= 3;
        }
        
        return ans * n;
    }
}
