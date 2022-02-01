class Solution {
    // Approach: Calculate boundaries and repeat
    public int[][] generateMatrix(int n) {
        int count = 0;
        int[][] matrix = new int[n][n];
        for(int k =0; k< (int) Math.ceil(n/2.0); k++){
            int last = n-k-1;
            for(int j=k; j < last; j++){
                matrix[k][j] = ++count;
            }
            for(int i=k; i < last; i++){
                matrix[i][last]= ++count;
            }
            for(int j=last; j > k; j--){
                matrix[last][j]= ++count;
            }
            for(int i=last; i > k; i--){
                matrix[i][k] = ++count;
            }
        }
        if(n % 2 == 1){
            matrix[n/2][n/2] = ++count;
        }
        return matrix;
    }
}
