import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int m = rows;
        int n = cols;

        List<int[]> res = new ArrayList<>();

        // keep tracks for length and direction in which we move
        int rowLen = 1;
        int colLen = 1;
        int horizontalDir = 1;
        int verticalDir = -1;

        int row = rStart;
        int col = cStart;
        int count = 0;
        while(count < m * n){ // we haven't visited all cells yet
            // we move in horizontal dirs for given len
            if(horizontalDir > 0){
                // move rightwards
                int rightMostIdx = col + rowLen - 1; // lagging 
                while(col <= rightMostIdx){
                    // visit this if not out of bounds
                    if(row >= 0 && row < m && col >= 0 && col < n){
                        res.add(new int[]{row, col});
                        count++;
                    }
                    col++;
                }
            }else{
                // move leftwards
                int leftMostIdx = col - rowLen + 1; // lagging
                while(col >= leftMostIdx){
                    // visit this if not out of bounds
                    if(row >= 0 && row < m && col >= 0 && col < n){
                        res.add(new int[]{row, col});
                        count++;
                    }
                    col--;
                }
            }

            if(verticalDir < 0){
                // move down
                int bottomMostIdx = row + colLen - 1; // lagging
                while(row <= bottomMostIdx){
                    // visit this if not out of bounds
                    if(row >= 0 && row < m && col >= 0 && col < n){
                        res.add(new int[]{row, col});
                        count++;
                    }
                    row++;
                }
            }else{
                // move up
                int topMostIdx = row - colLen + 1; // lagging
                while(row >= topMostIdx){
                    // visit this if not out of bounds
                    if(row >= 0 && row < m && col >= 0 && col < n){
                        res.add(new int[]{row, col});
                        count++;
                    }
                    row--;
                }
            }

            // change directions and length
            horizontalDir *= -1;
            verticalDir *= -1;
            rowLen++;
            colLen++;
        }

        return res.stream().toArray(int[][]::new);
    }
}
