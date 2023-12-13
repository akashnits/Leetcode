class Solution {
    // pre-compute rowCount and colCount
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int res =0;

        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        for(int row=0; row < m; row++){
            for(int col=0; col < n; col++){
                rowCount[row] += mat[row][col];
            }
        }

        for(int col=0; col < n; col++){
            for(int row=0; row < m; row++){
                colCount[col] += mat[row][col];
            }
        }

        // loop over matrix
        for(int i=0; i< m; i++){
            for(int j=0; j< n; j++){
                // check if rowCount and colCount equals if we find 1
                if(mat[i][j] == 1 && rowCount[i] == 1 && colCount[j] == 1){
                    // special position
                    res++;
                }
            }
        }

        return res;
    }
}
