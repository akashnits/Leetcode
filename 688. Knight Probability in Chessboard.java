class Solution {
    int[][] directions = {{-2,1}, {-1,2}, {1,2}, {2,1}, {-2,-1}, {-1,-2}, {1,-2}, {2,-1}};
    public double knightProbability(int n, int k, int row, int col) {
        double res;
        // dp array
        double[][][] dp = new double[n][n][k+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        // calculate number of +ve outcomes after K moves
        double favOutcomes = countPositiveOutcomes(dp, n , k, row, col);

        // number of outcomes
        double totalOutcomes = Math.pow(8.0, k);
        res = favOutcomes/totalOutcomes;
        return res;
    }



     double countPositiveOutcomes(double[][][] dp, int n, int k, int row, int col){
        // base condition
        // check out of bounds
        if( row < 0 || row > n-1 || col < 0 || col > n-1){
            return 0;
        }

        // no more moves, return 1 as it's on the board
        if( k == 0){
            return 1;
        }

        if(dp[row][col][k] != -1){
            return dp[row][col][k];
        }
       
        double count =0;
        
        // choice is to move in 8 directions
        for(int[] direction: directions){
            //  make a move
            count += countPositiveOutcomes(dp, n, k-1, row + direction[0] , col + direction[1]);
        }

        return dp[row][col][k] = count;
    }
}
