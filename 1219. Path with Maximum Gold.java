class Solution {
    int[][] dirs = {{-1,0}, {1,0}, {0, -1}, {0, 1}};
    public int getMaximumGold(int[][] grid) {
        // start from each cell in the grid and find the maxGold
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int r=0; r < m; r++){
            for(int c=0; c < n; c++){
                // maxGold would be set for this start point
                res = Math.max(res, calculateMaxGold(grid, r, c, m, n, new boolean[m][n]));
            }
        }
        return res;
    }

    int calculateMaxGold(int[][] grid, int row, int col, int m, int n, boolean[][] visited){
        // base condition - return if
        // case 1: out of bounds
        // case 2: already visited
        // case 3: grid[row][col] == 0

        if(row < 0 || col < 0 || row >= m || col >= n || grid[row][col] == 0 || visited[row][col]){
            return 0;
        }

        

        int maxGold =0;
        // take gold and move in all directions
        for(int[] dir: dirs){
            // mark visited
            visited[row][col] = true;
            int totalGold = grid[row][col] + calculateMaxGold(grid, row+dir[0], col+dir[1], m, n, visited);
            maxGold = Math.max(totalGold, maxGold);
            //backtrack
            visited[row][col] = false;
        }
        return maxGold;
    }
}
