class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public int[][] highestPeak(int[][] isWater) {
        List<int[]> srcPoints = new ArrayList();
        for(int row = 0; row < isWater.length; row++){
            for(int col = 0; col < isWater[0].length; col++){
                if(isWater[row][col] == 1){
                    srcPoints.add(new int[]{row, col});
                }
            }
        }
        return bfs(isWater, srcPoints);
    }

    // multi-source bfs - the nearer the land is to water, lesser is the height 
    // max height is decided by water present nearest to it i.e bfs from water 
    int[][] bfs(int[][] isWater, List<int[]> sourcePoints) {
        int m = isWater.length;
        int n = isWater[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int[][] height = new int[m][n];

        // Initialize the queue with all source points
        queue.addAll(sourcePoints);
        for (int[] point : sourcePoints) {
            visited[point[0]][point[1]] = true; // Mark water cells as visited
        }

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] coord = queue.poll();
                int x = coord[0];
                int y = coord[1];
                height[x][y] = level;

                // Move in all four directions
                for (int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    // Check if in bounds and not visited
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                        queue.offer(new int[]{newX, newY});
                        visited[newX][newY] = true; // Mark as visited when adding to queue
                    }
                }
            }
            level++;
        }
        return height;
    }
}
