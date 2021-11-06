class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        
        int m= mat.length;
        int n= mat[0].length;
        if(m*n != r*c)
            return mat;
        
        int[][] result = new int[r][c];
        // always a good idea to keep indices separate from for loop
        int k=0, l=0;
        for(int i=0; i < r; i++){
            for(int j=0; j < c; j++, l++){
                // check if we have reached end coulmn of given matrix
                if(l == n){
                    //this is last column of given matrix, we need to change row now
                    k++;
                    // reset column to 0 
                    l=0;
                }
                result[i][j] = mat[k][l];
            }
        }
        return result;
    }
}
