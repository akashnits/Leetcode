class Solution {
    public int[][] transpose(int[][] matrix) {
        // swap row and column
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] transposeMatrix = new int[cols][rows];

        for(int i=0; i < matrix.length; i++){
            for(int j=0; j < matrix[0].length; j++){
                transposeMatrix[j][i] = matrix[i][j];
            }
        }
        return transposeMatrix;
    }
}
