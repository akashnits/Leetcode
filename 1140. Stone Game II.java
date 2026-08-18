class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        Integer[][][] dp = new Integer[n][n+1][2];
        int res = computeAliceScore(piles, n, 0, 1, 0, dp);
        return res;
    }


    int computeAliceScore(int[] piles, int n, int idx, int m, int turn, Integer[][][] dp){
        if(idx >= n)
            return 0; // done here


        if(dp[idx][m][turn] != null){
            return dp[idx][m][turn];
        }
        
        if(turn == 0){
            // alice's turn 
            // maximize alice score: we try all choices from 1...2M and recurse
            int maxScoreAlice = Integer.MIN_VALUE;
            int currScore = 0;
            for(int x=1; x <= 2*m && (idx + x -1) < n; x++){ // choice we have
                currScore += piles[idx + x -1];
                maxScoreAlice = Math.max(maxScoreAlice, currScore + computeAliceScore(piles, n, idx+x, Math.max(m , x), 1, dp)); 
            }
            dp[idx][m][turn] = maxScoreAlice;
        }else{
            // bob's turn 
            // need to minimize alice's score
            int minScoreAlice = Integer.MAX_VALUE;
            for(int x=1; x <= 2*m && (idx + x -1) < n; x++){ // choice we have
                minScoreAlice = Math.min(minScoreAlice, computeAliceScore(piles, n, idx+x, Math.max(m , x), 0, dp)); 
            }
            dp[idx][m][turn] = minScoreAlice;
        }
        return dp[idx][m][turn];
    }
}
