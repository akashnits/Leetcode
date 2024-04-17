class Solution {
    public int maximalRectangle(char[][] matrix) {
        // for each cell in the column, caluculate height
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] heightsMatrix = new int[m][n];
        // copy values from first row
        for(int j =0; j < n; j++){
            heightsMatrix[0][j] = (int) (matrix[0][j]-'0');
        }

        for(int j=0; j < n; j++){
            for(int i=1; i < m; i++){
                // if cell is 0, leave it as is
                if(matrix[i][j] != '0'){
                    // base is non-zero, cell would be either curr or sum of prev + curr
                    heightsMatrix[i][j] = heightsMatrix[i-1][j] + (int) (matrix[i][j]-'0');
                }
            }
        }

        // to find the maximal rectangle we need to pass reach row as heights array in the method
        int res = 0;
        for(int[] heights: heightsMatrix){
            res = Math.max(res, findMaxAreaRectangle(heights));
        }
        return res;
    }


    int findMaxAreaRectangle(int[] heights){
        // we wwan to expand in both diretions until we find smaller height
        // pre-compute smaller height in both directions
        int n = heights.length;

        int[] nextSmallerToLeft = new int[n];
        Arrays.fill(nextSmallerToLeft, -1);

        int[] nextSmallerToRight = new int[n];
        Arrays.fill(nextSmallerToRight, n);

        // use monotonic stack to find next smaller to left/right
        // pre-compute next smaller to right
        Stack<Integer> rst1= new Stack();
        for(int i=0; i < n; i++){
            while(!rst1.isEmpty() && heights[i] < heights[rst1.peek()]){
                int popped = rst1.pop();
                nextSmallerToRight[popped] = i;
            }
            rst1.push(i);
        }

        // pre-compute next smaller to left
        Stack<Integer> lst1= new Stack();
        for(int j=n-1; j >= 0; j--){
            while(!lst1.isEmpty() && heights[j] < heights[lst1.peek()]){
                int popped = lst1.pop();
                nextSmallerToLeft[popped] = j;
            }
            lst1.push(j);
        }
        
        // calculate area and find max
        int max = 0;

        for(int k =0; k < n; k++){
            int height = heights[k] * (nextSmallerToRight[k] - nextSmallerToLeft[k]-1);
            max = Math.max(max, height);
        }
        return max;
    }
}
