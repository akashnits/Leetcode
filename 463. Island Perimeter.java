class Solution {
    public int islandPerimeter(int[][] grid) {
        // adjacent cells loses 2*side from perimeter

        // count the adjacent cells check the right and down cell
        int m = grid.length;
        int n = grid[0].length;

        int adjacentCells = 0;
        int land = 0;

        for(int row=0; row < m; row++){
            for(int col = 0; col < n; col++){
                // if water continue
                if(grid[row][col] == 0) continue;
                land++;

                // look towards right and down
                if(col + 1 < n && grid[row][col+1] == 1){
                    // check if right is land
                    adjacentCells++;
                }

                if(row+1 < m && grid[row+1][col] == 1){
                    adjacentCells++;
                }
            }
        }

        return(4*land - 2*adjacentCells);
    }
}
