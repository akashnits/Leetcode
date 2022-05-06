class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        
        int row = grid.length;
        int col = grid[0].length;
        for(int i=0; i < row; i++){
            for(int j=0; j < col; j++){
                if(grid[i][j] == '1'){
                    islands++;
                    mark_connected_islands(grid, i, j, row, col);
                }
            }
        }
        
        return islands;
    }
    
    // we mark all connected islands - 2
    private void mark_connected_islands(char[][] grid, int i, int j, int row, int col){
        if( i >= row || i < 0 || j >= col || j < 0 || grid[i][j] != '1'){
            return;
        }
        
        grid[i][j] = '2';
        // make recursive call in four directions
        mark_connected_islands(grid, i+1, j, row, col);
        mark_connected_islands(grid, i, j+1, row, col);
        mark_connected_islands(grid, i-1, j, row, col);
        mark_connected_islands(grid, i, j-1, row, col);
        return;
    }
}
