class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0; i< n ; i++){
            for(int j=0; j< n; j++){
                board[i][j]= '.';
            }
        }
        List<List<String>> result= new ArrayList();
        solve(board, n, 0, result);
        return result;
    }
    
    void solve(char[][] board, int rem, int row, List<List<String>> result){
        //base condition - when we don't have any more queens to place
        if(rem <= 0){
            result.add(constructList(board));
            return;
        }
        
        for(int i=0; i< board.length; i++){
            if(canPlace(board, row, i)){
                //make a choice - place Queen
                board[row][i] = 'Q';
                --rem;
                //recurse on choice
                solve(board, rem, row+1, result);
                
                ++rem;
                ///undo
                board[row][i] = '.';
            }
        }
    }
    
    
    // diagonal or antidiagonal
    // In simpler words, slope angle is either 45 or 135 degrees
    // tan 45 = 1, tan 135 = -1
    // slope = (y-j)/(x-i) i.e. (y-j)/(x-i)= 1 or -1 
    // y + i = x + j or y + x = i + j
    
    private boolean canPlace(char[][] mat, int x, int y) {
    // only check rows above current one
    for (int i = 0; i < x; i++) {
      for (int j = 0; j < mat.length; j++) {
        // not need to check current position
        if (i == x && j == y) { 
          continue;
        }
        // if 'Q' in the same col or the diagonal line, return false
        if ((j == y || Math.abs(x - i) == Math.abs(y - j)) && mat[i][j] == 'Q') {
          return false;
        } 
      }
    }
    return true;
  }
               
    private List<String> constructList(char[][] board) {
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}
