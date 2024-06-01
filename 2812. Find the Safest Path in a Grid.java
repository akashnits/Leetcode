class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        // pre-compute safeness factor of each cell
        // safeness factor of a cell = min[manhattan distance from theives cell]

        // we can make bfs call from all theives cell simulatenously and calculate distance if
        // cell is not visited - multi source bfs

        int m = grid.size();
        int n = grid.get(0).size();
        // base condition 
        if(grid.get(0).get(0) == 1 || grid.get(m-1).get(n-1) == 1){
            // if src or dest is a thief cell, no safeness
            return 0;
        }

        int[][] gridArr = new int[m][n];

        for(int i=0; i < m; i++){
            for(int j=0; j < n; j++){
                gridArr[i][j] = grid.get(i).get(j);
            }
        }

        int[][] safeness = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> queue = new LinkedList();
        // add all theif cell in the queue
        for(int r=0; r < m; r++){
            for(int c=0; c < n; c++){
                if(gridArr[r][c] == 1){
                    queue.offer(new int[]{r, c});
                    // mark it visited
                    visited[r][c] = true;
                }
            }
        }

        int dist = 0;
        // start bfs from multi-source
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i < size; i++){
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];

                // calculate manhattan distance and put in safeness arr
                safeness[row][col] = dist;

                // recurse - add next four directions 
                for(int[] dir: dirs){
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    // check out of bounds
                    if(newRow < 0 || newCol < 0 || newRow > m-1 || newCol > n-1 || visited[newRow][newCol]){
                        continue;
                    }
                    queue.offer(new int[]{newRow, newCol});
                    // mark it visited
                    visited[newRow][newCol] = true;
                }     
            }
            dist++;
        }

        // using dijkstra to find a path with max safeness
        // create a maxHeap 
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a, b) -> (b[2] - a[2]));

        int maxSafeness = safeness[0][0];
        // create a visited array 
        boolean[][] vtd = new boolean[m][n];
        // add src to maxHeap
        maxHeap.offer(new int[]{0, 0, safeness[0][0]});
        vtd[0][0] = true; // mark src visited

        // we want to traverse the grid to reach last cell and find maxSafeness along this path
        // for this we try to choose highest safeness cell with the help of maxHeap

        while(!maxHeap.isEmpty()){
            int[] polled = maxHeap.poll();
            int r = polled[0];
            int c = polled[1];
            int safe = polled[2];

            maxSafeness = Math.min(maxSafeness, safe); //safness along the path is min safeness 

            //check if this is last cell
            if(r == m-1 && c == n-1){
                return maxSafeness;
            }

            // go to neighbors and add to maxHeap 
            for(int[] dir:dirs){
                int newRow = r + dir[0];
                int newCol = c + dir[1];

                if(newRow < 0 || newCol < 0 || newRow > m-1 || newCol > n-1 || vtd[newRow][newCol]){
                    continue;
                }

                maxHeap.offer(new int[]{newRow, newCol, safeness[newRow][newCol]});
                // mark visited
                vtd[newRow][newCol] = true;               
            }

        }
        return -1;
    }
}
