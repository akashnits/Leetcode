class Solution {
    int[][] grid;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        grid = new int[m][n]; 
        // 0 = unguarded, 1 = guarded, 2 = guard, 3 = wall

        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 2;
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 3;
        }

        for (int[] guard : guards) {
            int gRow = guard[0];
            int gCol = guard[1];
            // move in one direction at one time until vision is blocked or reached end
            for (int[] dir : dirs) {
                dfs(m, n, gRow + dir[0], gCol + dir[1], dir);
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) res++;
            }
        }
        return res;
    }

    void dfs(int m, int n, int row, int col, int[] dir) {
        // stop if out of bounds
        if (row < 0 || row >= m || col < 0 || col >= n) return;

        // stop if this is a wall or guard
        if (grid[row][col] == 2 || grid[row][col] == 3) return;

        // mark as guarded
        if (grid[row][col] == 0) grid[row][col] = 1;

        // continue in the same direction only
        dfs(m, n, row + dir[0], col + dir[1], dir);
    }
}




class Solution {

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(grid[i], ' ');

        // Mark guards and walls
        for (int[] g : guards) grid[g[0]][g[1]] = 'G';
        for (int[] w : walls) grid[w[0]][w[1]] = 'W';

        // \U0001f539 Sweep each row both ways
        for (int i = 0; i < m; i++) {
            boolean inGuardView = false;

            // → Left → Right
            for (int j = 0; j < n; j++) {
                char c = grid[i][j];
                if (c == 'W') { inGuardView = false; continue; }
                if (c == 'G') { inGuardView = true; continue; }
                if (inGuardView && c == ' ') grid[i][j] = 'V';
            }

            // ← Right → Left
            inGuardView = false;
            for (int j = n - 1; j >= 0; j--) {
                char c = grid[i][j];
                if (c == 'W') { inGuardView = false; continue; }
                if (c == 'G') { inGuardView = true; continue; }
                if (inGuardView && c == ' ') grid[i][j] = 'V';
            }
        }

        // \U0001f539 Sweep each column both ways
        for (int j = 0; j < n; j++) {
            boolean inGuardView = false;

            // ↓ Top → Bottom
            for (int i = 0; i < m; i++) {
                char c = grid[i][j];
                if (c == 'W') { inGuardView = false; continue; }
                if (c == 'G') { inGuardView = true; continue; }
                if (inGuardView && c == ' ') grid[i][j] = 'V';
            }

            // ↑ Bottom → Top
            inGuardView = false;
            for (int i = m - 1; i >= 0; i--) {
                char c = grid[i][j];
                if (c == 'W') { inGuardView = false; continue; }
                if (c == 'G') { inGuardView = true; continue; }
                if (inGuardView && c == ' ') grid[i][j] = 'V';
            }
        }

        //  Count unguarded cells
        int unguarded = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == ' ') unguarded++;

        return unguarded;
    }
}
