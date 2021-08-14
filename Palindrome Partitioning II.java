class Solution{
    //Note: this code my exceed time limit on Leetcode but accepted on GFG
    static int palindromicPartition(String s)
    {
        // code here
    //using matrix chain multiplication to solve this
    //dp[i][j] give the min cost of partition for the String s from i to j
    
          int n = s.length();
        
          int[][] dp = new int[n][n];
        
        //initlialize dp array with -1
        for(int i=0; i < n; i++){
            for(int j=0; j < n; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
          return solve(s, 0, n-1, dp);  
    }
    
    static int solve(String s, int i, int j, int[][] dp){
        //base condition
        if(i == j){
            //we cant partition futher
            dp[i][j]=0;
            return dp[i][j];
        }
        
        if(isPalindrome(s, i, j)){
            //no need to partition as we already have a palindrome
            dp[i][j]=0;
            return dp[i][j];
        }
        
        if(dp[i][j] != Integer.MAX_VALUE){
            return dp[i][j];
        }
        
        //choice diagram
        for(int k=i; k<j; k++){
            // 1 is the cost of partitioning
            dp[i][j] = Math.min(dp[i][j], (1 + solve(s, i, k, dp) + solve(s, k+1, j, dp)));
        }
        return dp[i][j];
    }
    
    static boolean isPalindrome(String s, int i, int j){
        while( i < j ){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
