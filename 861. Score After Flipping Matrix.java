class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // loop over all rows and check if MSB is zero - flip it
        for(int[] row: grid){
            if(row[0] == 1)
                continue; // MSB is set, don't flip
            for(int j=0; j<n; j++){
                // flip entire row
                row[j] = row[j] == 0? 1: 0;
            }
        }

        // loop over all the columns and count number of ones and zeros in a column
        for(int j=0; j < n; j++){
            // for this columns
            int ones =0;
            int zeroes =0;
            for(int i=0; i < m; i++){ // loop over all rows for this column
                if(grid[i][j] == 0){
                    zeroes++;
                }else{
                    ones++;
                }
            }

            // check if number of zeros > ones for this column
            if(zeroes > ones){
                // we need to flip the entire column
                for(int r=0; r < m; r++){
                    grid[r][j] = grid[r][j] == 0? 1: 0;
                }
            }
        }


        // convert the matrix in numbers and find score
        int score = 0;
        for(int[] row: grid){
            int num =0;
            for(int c=n-1; c >=0; c--){
                num += row[c] << (n-c-1);
            }
            score += num;
        } 

        return score;
    }
}
