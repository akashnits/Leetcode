class Solution {
    // dp two pass approach to find the min distance
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dist = new int[m][n];
        int maxRange = m * n; // Large enough value instead of Integer.MAX_VALUE

        // First pass (Top-left to Bottom-right)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = maxRange;
                    if (i > 0) dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                    if (j > 0) dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                }
            }
        }

        // Second pass (Bottom-right to Top-left)
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i < m - 1) dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                if (j < n - 1) dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
            }
        }

        return dist;
    }
}
