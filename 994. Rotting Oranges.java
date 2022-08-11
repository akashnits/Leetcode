class Solution {
    public int orangesRotting(int[][] grid) {
        
        int count =0;
        int freshOranges = 0;
        Queue<int[]> queue = new ArrayDeque();
        
        int m = grid.length;
        int n = grid[0].length;
        
        for(int row=0; row < m; row++){
            for(int col=0; col < n; col++ ){
                if(grid[row][col] == 2){
                    // add to queue
                    queue.offer(new int[]{row, col});
                }else if(grid[row][col] == 1){
                    freshOranges++;
                }
            }
        }
        
        if(freshOranges == 0){
            return 0;
        }
        
        if(queue.isEmpty()){
            return -1;
        }
        
                
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int j=0; j < size; j++){
                // poll here
                int[] polled = queue.poll();
                int row = polled[0];
                int col = polled[1];
            
                //move in 4 directions and check for rotten oranges
                int[] dirs = {-1, 0, 1, 0, -1};
                for(int i=0; i < 4; i++){
                    int nr = row + dirs[i];
                    int nc = col + dirs[i+1];
                
                    // check if already rotten/ empty / invalid
                
                    if(nr < 0 || nr == m || nc < 0 || nc == n || grid[nr][nc] != 1 ){
                        continue;
                    }
                
                    // we have a fresh orange which we need to rot
                    grid[nr][nc] = 2;
                    queue.offer(new int[]{nr, nc});
                    freshOranges--;
                }
            }
            count++;
        }
        return freshOranges == 0? count-1: -1;
    }
    
    
}
