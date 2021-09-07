class Solution {
    public int numTrees(int n) {
        //formula for this: G(n) = F(1, n) + F(2 ,n) + F(3, n)... + F(n, n)
        // where G(n)= summation of all F(i, n) till n
        //F(i,n) is the number of unique bst rooted at i
        
        //rewriting abobe equation
        // G(n)= G(0) * G(n-1) + G(1) * G(n-2) + G(2) * G(n-3)...  + G(n-1) * G(0)
        
        int[] dp= new int[n+1];
        dp[0]= 1;
        dp[1]= 1;
        
         for(int i=2; i<=n; i++) {
            for(int j=1; j<=i; j++) {
            // dp[i] is number of bst that can be constructed with sequence 1,2,3...i
            // summing bst rooted at 1, 2, 3.. i will give dp[i]    
            dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
