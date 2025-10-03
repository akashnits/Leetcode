class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        // flip horizontal
        int m = image.length; // rows
        int n = image[0].length; // cols
        
        int colMid = n /2;
        
        for(int row = 0; row < m; row++){
            for(int col =0; col < colMid; col++){
                // swap
                int temp = image[row][col];
                image[row][col] = image[row][n-1-col];
                image[row][n-1-col] = temp;
            }
        }
        
        // invert
        for(int row =0; row < m; row++){
            for(int col=0; col < n; col++){
                image[row][col] = image[row][col] == 0 ? 1 : 0;
            }
        }
        return image;
    }
}
