class Solution {
    // dp[i][j] represents the min sum of falling path at i,j
    public int minFallingPathSum(int[][] matrix) {
          int n = matrix.length;
          int dp[][] = new int[n][n];
          

          dp[0][0] = matrix[0][0];
          // initialize dp array
          for(int j=1; j < n; j++){
              dp[0][j] = matrix[0][j];
          }


          for(int i=1; i< n; i++){
              for(int j=0; j< n; j++){
                  if(j == 0){
                      if(j == n-1){
                        dp[i][j] = dp[i-1][j];  
                      }else{
                       dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j+1]) + matrix[i][j];
                      }
                  }else{
                      dp[i][j] = (j == n-1? 
                              Math.min(dp[i-1][j], dp[i-1][j-1])
                              : Math.min(dp[i-1][j], Math.min(dp[i-1][j-1],dp[i-1]                                   [j+1]))) + matrix[i][j];
                  }
              }
          }
          int min = dp[n-1][0];  
          for(int j=1; j < n; j++){
              min = Math.min(min, dp[n-1][j]);
          }  

          return min;
    }
}
