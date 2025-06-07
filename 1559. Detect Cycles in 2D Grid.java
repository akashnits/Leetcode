class Solution {
    boolean[][] visited;
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        visited = new boolean[m][n];

        int res = 0;
        for(int i =0; i < m; i++){
            for(int j=0; j < n; j++){
                // dfs call from each unvisited cell
                if(visited[i][j]) continue; 
                // mark visited 
                visited[i][j] = true;
                if(findCycle(grid, m, n, grid[i][j], i, j, -1, -1)){
                    return true;
                }
            }
        }
        return false;
    }


    boolean findCycle(char[][] grid, int m, int n, char ch, int r, int c, int parentR, int parentC){
        // move in all four directions
        for(int[] dir: dirs){
            int newRow = r + dir[0];
            int newCol = c + dir[1];

            // check if out of boundary or already visited
            if(newRow < 0 || newCol < 0 || newRow > m-1 || newCol > n-1){
                continue;
            }

            // skip un-related char
            if(grid[newRow][newCol] != ch){
                continue;
            }

            // newRow, newCol points to visited node
            if(visited[newRow][newCol] && (parentR != newRow || parentC != newCol)){
                // back edge
                return true;
            }

            if(visited[newRow][newCol]) continue; // already visited, skip it 

            visited[newRow][newCol] = true;
            if(findCycle(grid, m, n, ch, newRow, newCol, r, c)){
                // found cycle
                return true;
            }
        }
        return false;
    }
}
