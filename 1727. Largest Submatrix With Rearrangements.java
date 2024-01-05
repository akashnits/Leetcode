class Solution {
    public int largestSubmatrix(int[][] matrix) {
        // matrix containing consecutive ones count in each column , we call it height
        int m = matrix.length;
        int n = matrix[0].length;

        for(int j=0; j < n; j++){
            int height = 0;
            for(int i=0; i < m; i++){
                if(matrix[i][j] == 0){
                    // reset height
                    height = 0;
                }else{
                    matrix[i][j] = ++height;
                }
            }
        }

        // we now have the height, we need to maximize base and height to maximize area
        // grouping together columns with larger heights to maximize area
        int area =0;
        // sort the columns are per row values
        for(int i=0; i < m; i++){
            int[] row = matrix[i];
            Arrays.sort(row);
            for(int j=n-1; j > -1; j--){
                area = Math.max(area, (n-j) * row[j]);
            }
        }
        return area;
    }
}
