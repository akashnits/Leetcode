class Solution {
    // dp two pass approach to find the min distance
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dist = new int[m][n];
        int maxRange = m * n; // Large enough value instead of Integer.MAX_VALUE

        for(int i=0; i < m; i++){
            for(int j=0; j < n; j++){
                if(matrix[i][j] == 1){
                    dist[i][j] = maxRange;
                }
            }
        }

        // First pass (Top-left to Bottom-right)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                if (j > 0) dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
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

class Solution {
    // Approach: we need to find the min distance from water to land 
    // bfs probably ?
    // we traverse the matrix and make a bfs call when we see 1 to find nearest 0
    // or better we could use multi-source bfs, start bfs simmultaneously at all 0
    // we update the distance once we reach 1 and mark visited - this way nearest 1 is reached
    // the earliest, hence, min distance
    int[][] dist;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public int[][] updateMatrix(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) {
        return matrix;
    }
    int[][] dis = new int[matrix.length][matrix[0].length];
    int range = matrix.length * matrix[0].length;
    
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[i][j] == 0) {
                dis[i][j] = 0;
            } else {
                int upCell = (i > 0) ? dis[i - 1][j] : range;
                int leftCell = (j > 0) ? dis[i][j - 1] : range;
                dis[i][j] = Math.min(upCell, leftCell) + 1;
            }
        }
    }
    
    for (int i = matrix.length - 1; i >= 0; i--) {
        for (int j = matrix[0].length - 1; j >= 0; j--) {
            if (matrix[i][j] == 0) {
                dis[i][j] = 0;
            } else {
                int downCell = (i < matrix.length - 1) ? dis[i + 1][j] : range;
                int rightCell = (j < matrix[0].length - 1) ? dis[i][j + 1] : range;
                dis[i][j] = Math.min(Math.min(downCell, rightCell) + 1, dis[i][j]);
            }
        }
    }
    
    return dis;
}
}
