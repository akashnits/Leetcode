class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int m = (2 * n);
        Integer[][][] dp = new Integer[n][m][2];
        return calculateMaxScoreForAlice(piles, piles.length, 0, 1, 0, dp);
    }

    int calculateMaxScoreForAlice(int[] piles, int n, int i, int m, int turn, Integer[][][] dp){
        // base condition
        if( i == n){
            return 0;
        }

        if(dp[i][m][turn] != null){
            return dp[i][m][turn];
        }

        // what choices does Alice/bob have ?
        // Alice/Bob can take first X remaining piles which range from 1 ... 2M
        if(turn == 0){
            // Alice's turn, she can take first X remaining piles
            int score = 0;
            int maxScore = Integer.MIN_VALUE;
            for(int x=1; x <= Math.min(2*m, n-i); x++){
                score += piles[i+x -1];
                maxScore = Math.max(maxScore, score + calculateMaxScoreForAlice(piles, n, i+x, 
                                                        Math.max(m, x), 1, dp));    
            }
            return dp[i][m][turn] = maxScore;
        }else{
            // Bob's turn, he can take first X remaining piles
            int score = 0;
            // minimize Alice's score
            int minScore = Integer.MAX_VALUE;
            for(int x=1; x <= Math.min(2*m, n-i); x++){
                score += piles[i+x -1];
                minScore = Math.min(minScore,  calculateMaxScoreForAlice(piles, n, i+x, 
                                                Math.max(m, x), 0, dp));    
            }
            return dp[i][m][turn] = minScore;
        }
    }
}
