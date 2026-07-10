class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // we want to approach this problem by converting from 
        // searching in 4 dirs-> 2 dirs
        // we can do this by selecting max value in a column
        // then for that element in the row, find peak element
        // ^^ do this iteratively

        int l = 0;
        int r = n-1;

        // binary search to find peak
        while(l <= r){
            int mid = l + (r-l)/2; // this is the column we need to find max in 
            int max = -1;
            int maxRow = -1;
            // find the row containing max value in mid column
            for(int row=0; row < m; row++){
                if(mat[row][mid] > max){
                    max = mat[row][mid];
                    maxRow = row;
                }
            }

            // for this row, decide the search space
            // we discard downward slope

            int leftVal = (mid > 0 ? mat[maxRow][mid-1]: 0);
            int rightVal = (mid < n-1? mat[maxRow][mid+1] : 0);

            if(leftVal < mat[maxRow][mid] && rightVal < mat[maxRow][mid])
                return new int[]{maxRow, mid};
            else if(leftVal < mat[maxRow][mid])
                l = mid+1; // discard left side
            else
                r = mid-1;                
        }
        return new int[]{-1, -1};
    }
}
