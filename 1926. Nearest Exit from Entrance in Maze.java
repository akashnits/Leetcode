class Solution {
    // typical bfs problem
    int[][] dirs= {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int nearestExit(char[][] maze, int[] entrance) {
        // move in all four direction and figure out if it's the exit
        Queue<int[]> q = new ArrayDeque();
        q.add(entrance);
        int m = maze.length;
        int n = maze[0].length;

        boolean[][] isVisited = new boolean[m][n];

        int distance = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i < size; i++){
                int[] polled = q.poll();
                int row = polled[0];
                int col = polled[1];
                // check if this is the exit ? - early exit
                if(isExit(entrance, maze, row, col)){
                    return distance;
                }

                // add neighboring nodes to the queue - no out of bounds or walls or visited
                for(int[] dir: dirs){
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if(isOutOfBounds(newRow, newCol, maze) || maze[newRow][newCol] == '+' || isVisited[newRow][newCol]){
                        continue; 
                    }
                    // mark visited
                    isVisited[newRow][newCol] = true;
                    q.offer(new int[]{newRow, newCol});
                }
            }
            distance++;
        }
        return -1;
    }


    boolean isExit(int[] entrance, char[][] maze, int row, int col){
        // check if boundary
        if(row == 0 || row == maze.length-1 || col == 0 || col == maze[0].length-1){
            // check if not entrance and not a wall
            if(!(entrance[0] == row && entrance[1] == col) && maze[row][col] != '+'){
                return true;
            }
        }
        return false;
    }

    boolean isOutOfBounds(int row, int col, char[][] maze){
        return (row < 0 || row > maze.length-1 || col < 0 || col > maze[0].length-1); 
    }
}
