class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (a[2] - b[2])); // minheap

        // add src
        pq.offer(new int[]{0, 0, grid.get(0).get(0)});

        // state is (row, col, pathEffort)
        // use dijkstra to find  path with min effort

        boolean[][] visited = new boolean[m][n];
        
        while(!pq.isEmpty()){
            int[] polled = pq.poll(); // processed

            int r = polled[0], c = polled[1], pathEffort = polled[2];

            // check if we reached the end cell
            if(r == m-1 && c == n-1){
                return pathEffort < health;
            }

            // check if already visited
            if(visited[r][c])
                continue; // no need to process duplicate values
            visited[r][c] = true;

            // we only explore the neighbors if effort is lesser tha health here as effort is non-decreasing
            if(pathEffort >= health)
                continue;

            // explore it's neighbors
            for(int[] dir: dirs){
                int newR = r + dir[0];
                int newC = c + dir[1];

                // check bounds/not visited etc.
                if(newR < 0 || newR > m-1 || newC < 0 || newC > n-1 || visited[newR][newC] )
                    continue;

                // compute next state
                int newPathEffort = pathEffort + grid.get(newR).get(newC);
                if (newPathEffort >= health) continue;
                pq.offer(new int[]{newR, newC, newPathEffort});
            }    
        }
        return false;
    }
}
