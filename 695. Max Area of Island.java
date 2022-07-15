class Solution {
    
    // 0 -> can't expand
    // 1 -> process it
    // 2 -> already processed
    
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        
        for(int i=0; i < grid.length; i++){
            for(int j=0; j < grid[0].length; j++){
                max = Math.max(max, calculateArea(grid, i, j));
            }
        }
        
        return max;
    }
    
    
    
    
    int calculateArea(int[][] grid, int r, int c){
        int m = grid.length;
        int n = grid[0].length;
       // check if out of bounds; already processed; can't expand
        if(r < 0 || r > m-1 || c < 0 || c > n-1 || grid[r][c] == 2 || grid[r][c] == 0){
            return 0;
        }
        
        // include this and move in all directions
        grid[r][c] = 2;
        return 1 + calculateArea(grid, r+1, c) + calculateArea(grid, r-1, c) +
            calculateArea(grid, r, c+1) + calculateArea(grid, r, c-1);
    }
}
