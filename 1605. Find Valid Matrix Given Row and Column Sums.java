class Solution {
    // approach: n ~ 10^8 , we need to be greedy while picking values
    // while traversing, we pick the min(rowSum , colSum) to avoid sum > rowSum or colSum
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        // loop till i and j are out of bounds
        int m = rowSum.length;
        int n = colSum.length;

        int[][] matrix = new int[m][n];
        int i=0, j=0;

        while(i < m && j < n){
            // we pick the min(rowSum, colSum) and put it in the cell
            int val = Math.min(rowSum[i], colSum[j]);
            // put it in the cell
            matrix[i][j] = val;
            // as we have put this value, rowSum and colSum is decreased by val
            rowSum[i] -= val;
            colSum[j] -= val;

            // if rowSum == 0 or colSum == 0, we don't need to fill any values in that row or col further
            // increment counter
            if(rowSum[i] == 0){
                i++;
            }

            if(colSum[j] == 0){
                j++;
            }
        }
        return matrix;
    }
}
