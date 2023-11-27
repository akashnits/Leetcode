class Solution {
    int[][] directions = {{-1,-2}, {1,-2}, {-2,-1}, {2,-1}, {2,1}, {-2,1}, {-1, 2}, {1,2}};
    int MOD = (int) 1e9 + 7;
    public int knightDialer(int n) {
        int[][] matrix = new int[4][3];
        int count = 0;
        for(int row=0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                // matrix[row][col] represents the cell
                matrix[row][col] = ++count;
            }
        }

        // fill the last row
        for(int j=0; j < 3; j++){
            matrix[3][j] = -1;
        }
        matrix[3][1] = 0;

        int res = 0;
        int[][][] dp = new int[4][3][n]; // row, col, n
        for(int[][] mat: dp){
            for(int[] pat: mat){
                Arrays.fill(pat, -1);
            }
        }

        // jump from each position
        for(int a=0; a < 4; a++){
            for(int b=0; b < 3; b++){
                res= (res + calculateJumps(matrix, n-1, a, b, dp)) % MOD;
            }
        }
        return res;
    }


    int calculateJumps(int[][] matrix, int n, int row, int col, int[][][] dp){
        // check if landing invalid
        if(row < 0 || row > 3 || col < 0 || col > 2|| matrix[row][col] == -1){
            // can't dial from here
            return 0;
        }

        // valid landing and no further jump - dialed number
        if( n == 0){
            // no more jumps allowed
            return 1;
        }

        if(dp[row][col][n] != -1){
            return dp[row][col][n];
        }

        // move in all 8 directions
        int ans =0;
        for(int[] direction: directions){
            ans = (ans + calculateJumps(matrix, n-1, row+ direction[0], col + direction[1], dp)) % MOD;
        }
        dp[row][col][n] = ans;
        return ans;
    }
}
