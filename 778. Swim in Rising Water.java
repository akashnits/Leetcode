class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int swimInWater(int[][] grid) {
        // think in terms of cost from traveling from src to dest
        // cost of movement from one grid to another is Math.abs(grid[r1][c1] - grid[r2][c2])

        // we need to minimize this cost for src to destination path
        // typical dijkstra algo - find min cost path - min cost would be the max cost on that path

        // use minHeap to prioritise min cost path
        PriorityQueue<int[]> minHeap= new PriorityQueue<int[]>((a, b) -> (a[2] - b[2]));
        int n = grid.length;
        int[][] costArr = grid;
        boolean[][] visited = new boolean[n][n];

        int maxCostPath = Integer.MIN_VALUE;

        // add src to minHeap 
        minHeap.offer(new int[]{0, 0, costArr[0][0]});
        // mark visited
        visited[0][0] = true;

        while(!minHeap.isEmpty()){
            int[] polled = minHeap.poll();
            int r = polled[0];
            int c = polled[1];
            int cost = polled[2];

            maxCostPath = Math.max(maxCostPath, cost);

            // check if this is the destination
            if(r == n-1 && c == n-1){
                return maxCostPath;
            }

            // chocies - explore all neighbors
            for(int[] dir: dirs){
                int newRow = r + dir[0];
                int newCol = c + dir[1];

                // check if newRow and newCol isn't out of bounds or visited
                if(newRow < 0 || newCol < 0 || newRow > n-1 || newCol > n-1 || visited[newRow][newCol]){
                    continue;
                }

                // add this to minHeap 
                minHeap.offer(new int[]{newRow, newCol, costArr[newRow][newCol]}); 
                // mark visited
                visited[newRow][newCol] = true;
            }
        }
        return -1;
    }
}
