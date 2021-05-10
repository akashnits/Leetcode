class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
                        if(canPlace(board, i, j, c)){
                            board[i][j] = c; //Put c for this cell
                            boolean result;
                            
                            result= solve(board);
                            
                            if(result){
                                //we have found solution, no need to solve further
                                return true;
                            }else{
                                // we found that the character placed earlier wasn't
                                // correct, so we undo it and try other choices
                                board[i][j] = '.';
                            }
                        }
                    }
                    // returning false we couldn't find the solution 
                     // and we need to backtrack
                    return false;
                }
            }
        }
        return true;
    }
    
    
    private boolean canPlace(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            ///check row
            if(board[i][col] != '.' && board[i][col] == c) return false; 
            //check column
            if(board[row][i] != '.' && board[row][i] == c) return false; 
            //check 3*3 block
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' && 
board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; 
        }
        return true;
    }
}
