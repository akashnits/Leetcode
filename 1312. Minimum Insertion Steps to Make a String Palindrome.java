class Solution {
    // Idea: Calculate the count of LPS
    // LPS = LCS (s, reverse(s))
    // minInsertions = s.length() - LPS
    
    public int minInsertions(String s) {
        
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        String t = sb.reverse().toString();
        
        int dp[][] = new int[n + 1][n + 1];

        for (int i = 0; i < n+1; i++){
                dp[i][0] = 0;
        }
 
        for (int i = 1; i < n+1; i++){
                dp[0][i] = 0;
        }       

        //fill dp array in bottom-up fashion
            for(int i=1; i< n+1; i++){
                for(int j=1; j< n+1; j++){
                    if(s.charAt(i-1) == t.charAt(j-1)){
                        dp[i][j] = 1 + dp[i-1][j-1];
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                    }
                }
            }
        return s.length() - dp[n][n];
    }
}
