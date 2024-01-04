class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] rowOnes = new int[m];
        for(int i=0; i < m; i++){
            for(int j=0; j< n; j++){
                rowOnes[i] += grid[i][j]; 
            }
        }

        int[] colOnes = new int[n];
        for(int j=0; j < n; j++){
            for(int i=0; i < m ; i++){
                colOnes[j] += grid[i][j]; 
            }
        }

        int[][] diff = new int[m][n];
        for(int i=0; i < m; i++){
            for(int j=0; j < n; j++){
                diff[i][j] = 2 * rowOnes[i] + 2 * colOnes[j] - n - m;
            }
        }
       

        return diff;
    }
}
