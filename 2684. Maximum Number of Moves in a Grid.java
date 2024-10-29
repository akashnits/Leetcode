class Solution {
    int[][] dirs = {{-1, 1}, {0, 1}, {1, 1}};
    public int maxMoves(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        Integer[][] dp = new Integer[m][n];

        // start at each cell
        for(int i=0; i < m; i++){
            res = Math.max(res, moveForward(grid, m, n, i, 0, dp));
        }
        return res; 
    }

    // reach end of column and count moves
    int moveForward(int[][] grid, int m, int n, int row, int col, Integer[][] dp){
        // base condition: reached end col, row would be valid for sure
        if(col == n-1){
            return 0; // no moves required
        }

        if(dp[row][col] != null){
            return dp[row][col];
        }

        int maxMoves = 0;
        for(int[] dir: dirs){
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            // out of bounds
            if(newRow < 0 || newRow > m-1 || newCol < 0 || newCol > n-1){
                continue;
            }

            // only make a move if it's strictly greater
            if(grid[newRow][newCol] <= grid[row][col]){
                continue;
            }

            // make the move and recurse
            maxMoves = Math.max(maxMoves, 1 + moveForward(grid, m, n, newRow, newCol, dp));
        }
        return dp[row][col] = maxMoves;
    }
}
