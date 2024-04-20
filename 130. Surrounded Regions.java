class Solution {
    // approach: start from boundary and find all cells which are connected to boundary O
    // Turn them into 'C' - connected
    // iterate over the grid ( not boundary ) cells, turn C -> O and O -> X
    int[][] dirs = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int j=0; j < n; j++){
            // top boundary
            dfs(board, 0, j, new boolean[m][n]);
        }

        for(int i= 1; i < m; i++){
            // right boundary
            dfs(board, i, n-1, new boolean[m][n]);
        }

        for(int j=n-2; j >=0; j--){
            // bottom boundary
            dfs(board, m-1, j, new boolean[m][n]);
        }

        for(int i=m-2; i>=0; i--){
            //left boundary
            dfs(board, i, 0, new boolean[m][n]);
        }

        for(int i=1; i < m-1; i++){
            for(int j=1; j < n-1; j++){
                // turn C -> O and O -> X
                if(board[i][j] == 'C'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    // capture this as not connected to boundary
                    board[i][j] = 'X';
                }
            }
        }
    }

    void dfs(char[][] board, int row, int col, boolean[][] visited){
        // base condition
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == 'X'){
            // can't reach here
            return;
        }

        // return if already visited
        if(visited[row][col]){
            return;
        }

        // mark visited
        visited[row][col] = true;

        if(board[row][col] == 'O'){
            // this is connected to boundary, convert to C
            // convert if it's not boundary cell
            if(!(row == 0 || col == 0 || row == board.length-1 || col == board[0].length-1)){
                board[row][col] = 'C';
            }
        }

        for(int[] dir: dirs){
            int newRow = row+ dir[0];
            int newCol = col + dir[1];
            
            dfs(board, newRow, newCol, visited);            
        }
    }
}
