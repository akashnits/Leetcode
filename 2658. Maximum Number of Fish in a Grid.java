class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited;
    public int findMaxFish(int[][] grid) {
        // there could be m*n nodes (max 100)
        // treat each cell as a graph node and try grouping them together
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        int max =0;

        // we want to group together neighboring nodes (non-zero)
        // for that, we need to traverse the graph (dfs/bfs)
        for(int r=0; r < m; r++){
            for(int c=0; c < n; c++){
                if(!visited[r][c] && grid[r][c] != 0){
                    // mark this visited
                    visited[r][c] = true;
                    int res = dfs(grid, m, n, r, c);
                    max = Math.max(max, res + grid[r][c]);
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int m, int n, int r, int c){
        int sum = 0;
        // go to all it's neighbors 
        for(int[] dir: dirs){
            int newRow = r + dir[0];
            int newCol = c + dir[1];

            // check if out of bounds or visited or land - skip
            if(newRow < 0 || newRow > m-1 || newCol < 0 || newCol > n-1 || 
                visited[newRow][newCol] || grid[newRow][newCol] == 0){
                continue;
            }

            // visiting this neighbor for the first time - mark it visited
            visited[newRow][newCol] = true;

            // take fish from neighbor and recurse
            sum = sum + grid[newRow][newCol] + dfs(grid, m, n, newRow, newCol);
        }
        return sum;
    }
}
