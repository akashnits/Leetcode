class Solution {
    // Idea is to start at boundary and figure out the cells reached
    // suppose we start at pacific boundary, we calculate all cells reached
    // lly, we start at atlantic bounday and calculate all cells reached
    // intersection of these cells will give answer
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int m = heights.length;
        int n = heights[0].length;
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        List<List<Integer>> ans = new ArrayList();
        
        // start at left and right boundary
        for(int i =0; i < m; i++){
            helper(i, 0, Integer.MIN_VALUE, heights, pacific);
            helper(i, n-1, Integer.MIN_VALUE, heights, atlantic);
        }
        
        // start at top and bottom boundary
        for(int j =0; j < n; j++){
            helper(0, j, Integer.MIN_VALUE, heights, pacific);
            helper(m-1, j, Integer.MIN_VALUE, heights, atlantic);
        }
        
        for(int i=0; i< m; i++){
            for(int j=0; j < n; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> pair = new ArrayList();
                    pair.add(i);
                    pair.add(j);
                    ans.add(pair);
                }
            }
        }
        
        return ans;
        
    }
    
    
    void helper(int r, int c, int height, int[][] heights, boolean[][] reached){
        int m = heights.length;
        int n = heights[0].length;
        // base condition
        if(r < 0 || r > m-1 || c < 0 || c > n-1 || height > heights[r][c] ||                 reached[r][c]){
            return;
        }
        
        reached[r][c] = true;
        
       
        
        helper(r+1, c, heights[r][c], heights, reached); 
        helper(r, c+1, heights[r][c], heights, reached); 
        helper(r-1, c, heights[r][c], heights, reached); 
        helper(r, c-1, heights[r][c], heights, reached);
        
        return;
        
    }
}
