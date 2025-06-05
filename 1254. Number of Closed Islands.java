class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    boolean[][] visited;

    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        visited = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // shouldn't be land neither should be visited
                if (grid[i][j] == 0 && !visited[i][j]) {
                    // mark visited
                    visited[i][j] = true;
                    if (!isReachable(grid, i, j, m, n)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    // DFS returns true if this island touches boundary (so it's NOT closed)
    boolean isReachable(int[][] grid, int r, int c, int m, int n) {

        boolean touchesBoundary = isBoundary(r, c, m, n);
        for (int[] dir : dirs) {
            int newR = r + dir[0];
            int newC = c + dir[1];
            // out of bounds or already visited or water - skip
            if(newR < 0 || newC < 0 || newR > m-1 || newC > n-1 || 
                    visited[newR][newC] || grid[newR][newC] == 1){
                continue;        
            }
            // mark visited
            visited[newR][newC] = true;
            touchesBoundary |= isReachable(grid, newR, newC, m, n);
        }
        return touchesBoundary;
    }

    boolean isBoundary(int r, int c, int m, int n){
        return (r == 0 || c == 0 || r == m-1 || c == n-1);
    }
}
