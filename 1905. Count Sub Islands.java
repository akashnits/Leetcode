class Solution {
    int[][] dirs = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} }; // Directions: down, up, right, left
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        int m = grid1.length;
        int n = grid1[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // If grid2 has land and it's part of a sub-island, count it
                if(grid2[i][j] == 1) {
                    if(dfs(grid1, grid2, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    boolean dfs(int[][] grid1, int[][] grid2, int row, int col) {
        // Base condition: water in grid2 or already visited - we prune recursion
        if(grid2[row][col] == 0 || grid2[row][col] == 2) {
            return true;
        }

        // If grid2 has land but grid1 has water, this can't be a sub-island
        if(grid1[row][col] != 1) {
            return false;
        }

        boolean isSubIsland = true;
        for(int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            // Mark the current cell as visited in grid2
            grid2[row][col] = 2;

            if(newRow < 0 || newRow >= grid1.length || newCol < 0 || newCol >= grid1[0].length){
                continue;
            }
            
            // Perform DFS in all four directions and combine the result
            isSubIsland = dfs(grid1, grid2, newRow, newCol) && isSubIsland;
        }

        return isSubIsland;
    }
}
