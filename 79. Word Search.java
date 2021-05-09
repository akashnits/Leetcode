class Solution {
    // we need to start from every cell of matrix and try to find the word
    // For finding the word, we go the backtracking way.
    // Base conditions: check boundaries, visited path, value not equal
    // we return true if we reach to end of word (index == word.length) so that we could backtrack
    // at every step, we have 4 choices to move in neighboring cells ( constrained by boundaries, visited , value not equal)
    // we recurse on the choices at every step and stop once index exceed length of word
    
    public boolean exist(char[][] board, String word) {
        
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i=0; i < board.length; i++){
            for(int j=0; j< board[i].length; j++){
                if(solve(board, i, j, 0, word.toCharArray(), visited )){
                    return true;
                }
            }
        }
        return false;
        
    }
    
    
    boolean solve(char[][] board, int row, int col, int index, char[] word, boolean[][] visited){
        //base conditions
        //check to see if we have reached at the end of the word
        if(index == word.length){
            return true;
        }
        
        //check boundaries, visited cell etc.
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length
          || visited[row][col]  || word[index] != board[row][col]){
            
            return false;
        }
        
        //make a choice
        visited[row][col]= true;
        
        //recurse
        boolean result = solve(board, row+1, col, index+1, word, visited) 
            || solve(board, row-1, col, index+1, word, visited)
            || solve(board, row, col+1, index+1, word, visited)
            || solve(board, row, col-1, index+1, word, visited);
        
        //undo
        visited[row][col]= false;
        
        return result;
    }
}
