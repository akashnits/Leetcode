class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        Integer[][][] dp = new Integer[m][target+1][n+1];
        int res = minCost(houses, cost, m, n, 0, target, 0, dp); 
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    int minCost(int[] houses, int[][] cost, int noHouses, int n, int idx, int neighborhoodRem, int prevColor, Integer[][][] dp) {
        // Base case: all houses are painted
        if (idx == noHouses) {
            return (neighborhoodRem == 0) ? 0 : Integer.MAX_VALUE;
        }

        if(dp[idx][neighborhoodRem][prevColor] != null){
            return dp[idx][neighborhoodRem][prevColor];
        }

        // If the house is already painted
        if (houses[idx] != 0) {
            int newNeighborhoods = (houses[idx] == prevColor) ? neighborhoodRem : neighborhoodRem - 1;
            // skip invalid states
            if(newNeighborhoods < 0){
                return Integer.MAX_VALUE;
            }
            return dp[idx][neighborhoodRem][prevColor] = minCost(houses, cost, noHouses, n, idx + 1, newNeighborhoods, houses[idx], dp);
        }

        // If the house is not painted, try all possible colors
        int minCost = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            int color = j + 1; // Convert 0-based to 1-based color
            int newNeighborhoods = (color == prevColor) ? neighborhoodRem : neighborhoodRem - 1;

            // Skip invalid states
            if (newNeighborhoods < 0) {
                continue;
            }

            int expense = minCost(houses, cost, noHouses, n, idx + 1, newNeighborhoods, color, dp);
            // skip invalid values
            if (expense != Integer.MAX_VALUE) {
                minCost = Math.min(minCost, cost[idx][j] + expense);
            }
        }
        return dp[idx][neighborhoodRem][prevColor] = minCost;
    }
}
