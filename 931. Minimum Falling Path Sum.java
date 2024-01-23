class Solution {
    int minSum = Integer.MAX_VALUE;
    int[] fallDirs = {-1, 0, 1};
    public int minFallingPathSum(int[][] matrix) {
        // dp[i][j] represents the sum at given i, j
        int m = matrix.length;
        int n = matrix[0].length;
        int[][]dp = new int[m][n];
        for(int[] row: dp){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        // start at each col in the first row
        int res = Integer.MAX_VALUE;
        for(int j=0; j < n; j++){
            res = Math.min(res, calculateMinSum(matrix, 0, j, dp));
        }
        return res;
    }

    int calculateMinSum(int[][] matrix, int row, int col, int[][] dp){
        if(row == matrix.length){
            // we have reached the end
            return 0;
        }


        if(dp[row][col] != Integer.MAX_VALUE){
            return dp[row][col];
        }

        // choice we have 
        for(int dir: fallDirs){
            // skip if col is out of bounds
            if(dir+col < 0 || dir+col > matrix[0].length-1){
                continue;
            }
            dp[row][col] = Math.min(dp[row][col], 
                                matrix[row][col] + calculateMinSum(matrix, row+1, dir+col, dp)); 
        }
        return dp[row][col];
    }
}
