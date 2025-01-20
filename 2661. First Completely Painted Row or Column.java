class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        // keep track of painted row and columns
        int m = mat.length;
        int n = mat[0].length;

        int[] paintedRows = new int[m];
        int[] paintedCols = new int[n];

        Map<Integer, int[]> map = new HashMap();
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                map.put(mat[row][col], new int[]{row, col});
            }
        }

        int k = arr.length;
        int idx = 0;
        while(idx < k){
            // find row and col
            int[] coord = map.get(arr[idx]);
            // paint it i.e. increment count for row and col
            paintedRows[coord[0]]++;
            paintedCols[coord[1]]++;

            if(paintedRows[coord[0]] == n || paintedCols[coord[1]] == m){
                break;
            } 
            idx++;
        }
        return idx;
    }
}
