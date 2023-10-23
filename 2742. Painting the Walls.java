class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        Long[][] dp = new Long[n][501];
        return (int) minCost(cost, time, 0, 0, dp);
    }


    long minCost(int[] cost, int[] time, int i, int totalWallsPainted, Long[][] dp){
        if(totalWallsPainted >= cost.length){
            // all walls painted
            return 0;
        }

        if(i >= cost.length){
            // all walls not painted but i reached
            return Integer.MAX_VALUE;
        }

        if(dp[i][totalWallsPainted] != null){
            return dp[i][totalWallsPainted];
        }


        // we have two options - paint, don't paint
        // if paint, 1 + time[i] can be painted at cost[i]
        // if not, skip it

        long paint = cost[i] + minCost(cost, time, i+1, totalWallsPainted + 1 + time[i], dp); 
        
        long dontPaint = minCost(cost, time, i+1, totalWallsPainted, dp); 

        return dp[i][totalWallsPainted] = Math.min(paint, dontPaint);
    }
}
