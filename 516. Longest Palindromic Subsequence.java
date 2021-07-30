class Solution {
    //idea: LPS(s) = LCS(s, reverse(s))
    // more on this in notes
    public int longestPalindromeSubseq(String s) {
        String reverseS = new StringBuilder(s).reverse().toString();
        return lcs(s, reverseS, s.length(), reverseS.length());
    }
    
    public int lcs (String X, String Y, int n, int m){
        
        //initialize dp array
        int[][] dp = new int[n+1][m+1];
        
        for(int i=0 ; i < n; i++){
            dp[i][0] = 0;
        }
        
        for(int j=0 ; j < m; j++){
            dp[0][j] = 0;
        }
        
        //fill up 2D dp matrix
        for(int i=1; i< n+1; i++){
            for(int j=1; j< m+1; j++){
                
                if(X.charAt(i-1) == Y.charAt(j-1)){
                    //include in subsequence
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[n][m];
    }
}
