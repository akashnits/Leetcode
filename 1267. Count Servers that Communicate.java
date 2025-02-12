class Solution {
    public int countServers(int[][] grid) {
        // dynamic programming
        // check if there's exist more than one server in a row or col
        // store this in boolean array

        int m = grid.length;
        int n = grid[0].length;

        boolean[] rowContainsMultipleServers = new boolean[m];
        boolean[] colContainsMultiplerServers = new boolean[n];

        for(int i=0; i < m; i++){
            int[] row = grid[i];
            int countOnes = 0;
            // check if this row contains more than 1 one ?
            for(int j=0; j < n; j++){
                if(row[j] == 1){
                    if(++countOnes > 1){
                        rowContainsMultipleServers[i] = true;
                        break;
                    }
                }
            }
        }

        for(int j=0; j < n; j++){
            // check this column for more than 1 one
            int countOnes = 0;
            for(int i=0; i < m; i++){
                if(grid[i][j] == 1){
                    if(++countOnes > 1){
                        colContainsMultiplerServers[j] = true;
                        break;
                    }
                }
            }
        }

        int serversCount = 0;
        for(int r=0; r < m; r++){
            for(int c=0; c < n; c++){
                if(grid[r][c] == 1){
                    // check if this row or col contains multiple servers
                    if(rowContainsMultipleServers[r] || colContainsMultiplerServers[c]){
                        serversCount++;
                    }
                }
            }
        }
        return serversCount;
    }
}
