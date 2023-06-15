class Solution {
    public int equalPairs(int[][] grid) {
        int res =0;
        // map of string(made of row elements ) to number of occurence 
        Map<String, Integer> map = new HashMap();
        StringBuilder sb;

        // iterate over rows
        for(int row[]: grid){
            sb = new StringBuilder();
            for(int ele: row){
                sb.append(ele);
                sb.append(",");
            }
            String key= sb.toString();
            map.put(key, map.getOrDefault(key, 0)+1);
        }

       
        // iterate over column
        for(int col=0 ; col < grid[0].length; col++){
             sb = new StringBuilder();
             for(int row = 0; row < grid.length; row++){
                sb.append(grid[row][col]);
                sb.append(",");
             }
             String key = sb.toString();
             // find it it exists in the map, if yes increment the count
            res += map.getOrDefault(key, 0);
        }
        return res;
    }
}
