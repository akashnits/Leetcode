class Solution {
    //idea: LCS is common letters in order e.g. "ea" is LCS for (sea, eat)
    // # of deletions from string b = b - LCS
    // # of deletions from string a = a - LCS
    // Total = a + b - 2 * LCS
    
    public int minDistance(String word1, String word2) {
	    int n= word1.length();
	    int m= word2.length();
	    
	    int[][] dp= new int[n+1][m+1];
            for (int i = 0; i < n+1; i++)
                dp[i][0] = 0;
 
            for (int i = 1; i < m+1; i++)
                dp[0][i] = 0;
               
            //fill dp array in bottom-up fashion
            for(int i=1; i< n+1; i++){
                for(int j=1; j< m+1; j++){
                    if(word1.charAt(i-1) == word2.charAt(j-1)){
                        dp[i][j] = 1 + dp[i-1][j-1];
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                    }
                }
            }
            
            return (n+m - 2* dp[n][m]);
    }
}
