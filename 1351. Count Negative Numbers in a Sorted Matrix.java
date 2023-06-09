class Solution {

    int count = 0;
    int[][] directions = {{0,-1}, {-1,0}};
    public int countNegatives(int[][] grid) {


        // int r = grid.length -1;
        // int c= grid[0].length-1;

        // moveAhead(r, c, new boolean[r+1][c+1], grid);
        // return count;

    int n = grid[0].length;
    int currRowNegativeIndex = n - 1;

    // Iterate on all rows of the matrix one by one.
    for (int[] row : grid) {
        // Decrease 'currRowNegativeIndex' so that it points to current row's last positive element.
        while (currRowNegativeIndex >= 0 && row[currRowNegativeIndex] < 0) {
            currRowNegativeIndex--;
        }
        // 'currRowNegativeIndex' points to the last positive element,
        // which means 'n - (currRowNegativeIndex + 1)' is the number of all negative elements.
        count += (n - (currRowNegativeIndex + 1));
    }
    return count;


    }

    public void moveAhead(int row, int col, boolean[][] visited, int[][] grid){
        
        // base condition
        if(row < 0 || col < 0){
            // out of bounds
            return;
        }

        if(visited[row][col] || grid[row][col] >= 0){
            return;
        }

        // increment count
        count++;
        // mark visited
        visited[row][col]= true;
        // move in both directions
        for(int[] direction: directions){
            moveAhead(row + direction[0], col + direction[1], visited, grid);
        }

    }
}
