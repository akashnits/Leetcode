class Solution {
    //approach : dp[i][j] represents the max length of square ending at (i,j)
    // we expand sqaure along diagonal.
    int m, n, maxLength= 0;
    public int maximalSquare(char[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        
        int[][] dp = new int[m][n];
        
        // initialize dp matrix
        for(int i=0; i < m; i++){
            for(int j=0; j< n; j++){
                dp[i][j] = matrix[i][j] - '0';
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        
        //iterate over given matrix
        for(int i=1; i < m; i++){
            for(int j=1; j < n; j++){
                
                if(matrix[i][j] == '1'){
                    
                    //check if all previous adjacent cells have values equals/greater than 1
                    // i.e. possibility of expanding sqaure
                    
                    if(dp[i-1][j] >= 1 && dp[i][j-1] >=1 && dp[i-1][j-1] >=1){
                        // try expanding the square
                        dp[i][j] += Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));//we expand along the diagonal if we want square
                        maxLength = Math.max(maxLength, dp[i][j]);
                    }
                }
            }
        }
        // return area of maximal square
        return maxLength * maxLength;
    }
}
