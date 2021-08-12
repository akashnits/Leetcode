class Solution {
    //Idea is to write a recirsive solution and use top-down dp
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        int[][] dp = new int[n+1][m+1];
        
        //initialize dp array with -1
        for(int i=0; i< n+1; i++){
            for(int j=0; j< m+1; j++){
                dp[i][j] = -1;
            }
        }
        return recurse(word1.toCharArray(), word2.toCharArray(), n, m, dp);
        
    }
    
    public int recurse(char[] word1, char[] word2, int n, int m, int[][] dp){
        if(n == 0 && m == 0){
            dp[n][m]=0;
            return dp[n][m];
        }else if( n == 0 ){
            dp[n][m]=m;
            return dp[n][m];
        }else if(m == 0){
            dp[n][m]=n;
            return dp[n][m];
        }
        
        //choice diagram
        if(word1[n-1] == word2[m-1]){
            // no operations required
            if(dp[n-1][m-1] == -1){
                dp[n][m] = recurse(word1, word2, n-1, m-1, dp);
            }else{
                dp[n][m] = dp[n-1][m-1];
            }
            return dp[n][m];
        }else{
            //we can replace/insert/delete
            //for replace
            if(dp[n-1][m-1] == -1){
                dp[n-1][m-1] = recurse(word1, word2, n-1, m-1, dp);
            }
            //for insert
            if(dp[n-1][m] == -1){
                dp[n-1][m] = recurse(word1, word2, n-1, m, dp);
            }
            //for delete
            if(dp[n][m-1] == -1){
                dp[n][m-1] = recurse(word1, word2, n, m-1, dp);
            }
            //chosing min of all operations
            dp[n][m] = 1 + Math.min(dp[n-1][m-1], Math.min(dp[n-1][m],dp[n][m-1]));
            return dp[n][m];
        }
    }
}
