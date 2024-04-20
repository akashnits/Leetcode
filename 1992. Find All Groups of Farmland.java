class Solution {
    public int[][] findFarmland(int[][] land) {
        // loop over all cells of land

        int m = land.length;
        int n = land[0].length;

        List<int[]> res = new ArrayList();

        for(int row=0; row < land.length; row++){
            for(int col = 0; col < land[0].length; col++){
                if(land[row][col] == 1){
                    // not visited, not forest
                    res.add(dfs(land, row, col));
                }
            }
        }
        int[][] resArray = res.stream().toArray(int[][]::new);

        return resArray;
    }

    int[] dfs(int[][] land, int row, int col){
        int r1 = row;
        int c1 = col;
        int r2 = r1;
        int c2= c1;

        // we start from (r1, c1) , try finding (r2, c2)
        // marking nodes as visited during iteration

        while(c2 < land[0].length && land[r2][c2] == 1){
            c2++;
        }

        c2--; // decrement as it's either out of bounds or land[r2][c2] == 0

        while(r2 < land.length && land[r2][c2] == 1){
            r2++;
        }

        r2--; // decrement as it's either out of bounds or land[r2][c2] == 0

        // mark all cells from (r1, c1) .. (r2, c2) as visited
        for(int i=r1; i <=r2; i++){
            for(int j=c1; j <= c2; j++){
                // mark visited
                land[i][j] = 2;
            }
        }

        return new int[]{r1, c1, r2, c2};
    }
}
