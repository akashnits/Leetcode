class Solution {
    // we can also convert a 2D matrix (m * n) to array: matrix[i][j] => arr[i*n+ j]
    // lly, we can convert a array to a 2D matrix (m * n): arr[x] => matrix[x/n][x%n]
  
    public boolean searchMatrix(int[][] matrix, int target) {
        //find the row to seach in
        // can be done by comparing the last element of each row with target
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int rowToSearch = -1;
        for(int i=0; i < m; i++){
            if(target <= matrix[i][n-1]){
                // this is the row we need to search in, save i
                rowToSearch = i;
                break;
            }
        }
        
        // we couldn't find the row to search target
        if(rowToSearch == -1)
            return false;
        
        // apply binary search to find target in that row
        return binarySearch(matrix, 0, n-1, rowToSearch, target);
        
    }
    
    
    private boolean binarySearch(int[][] arr, int l, int r, int rowToSearch, int target){
        if(l > r){
            return false;
        }
        
        int mid = l + (r-l)/2;
        
        if(arr[rowToSearch][mid] == target){
            //found target
            return true;
        }else if(target < arr[rowToSearch][mid]){
            //search left half
            return binarySearch(arr, l, mid-1, rowToSearch, target);
        }else{
            //search right half
            return binarySearch(arr, mid+1, r, rowToSearch, target);
        }
    }
}
