public class Solution {
    public String alphabetBoardPath(String target) {
        StringBuilder res = new StringBuilder();
        int[] prevCoords = new int[]{0, 0};

        for (char ch : target.toCharArray()) {
            int charIdx = ch - 'a';
            int row = charIdx / 5;
            int col = charIdx % 5;
            int prevRow = prevCoords[0];
            int prevCol = prevCoords[1];
            
            // move left
            if(col < prevCol){
                moveLeft(prevCol, col, res);
            }
            //move down
            if( row > prevRow ){
                moveDown(prevRow, row, res);
            }
            // move up
            if( row <  prevRow){
                moveUp(prevRow, row, res);
            }

            // move right
            if( col > prevCol){
                moveRight(prevCol, col, res);
            }

            // Append the '!' to indicate selecting the character
            res.append("!");
            // Update prevCoords to the current position
            prevCoords[0] = row;
            prevCoords[1] = col;
        }
        return res.toString();
    }

    private void moveLeft(int fromCol, int toCol, StringBuilder res) {
        int colDistance = toCol - fromCol;
        for (int i = 0; i < -colDistance; i++) {
            res.append("L");
        }
    }

    private void moveDown(int fromRow, int toRow, StringBuilder res) {
        int rowDistance = toRow - fromRow;
        for (int i = 0; i < rowDistance; i++) {
            res.append("D");
        }
    }

    private void moveUp(int fromRow, int toRow, StringBuilder res) {
        int rowDistance = toRow - fromRow;
        for (int i = 0; i < -rowDistance; i++) {
            res.append("U");
        }
    }

    private void moveRight(int fromCol, int toCol, StringBuilder res) {
        int colDistance = toCol - fromCol;
        for (int i = 0; i < colDistance; i++) {
            res.append("R");
        }
    }
}
