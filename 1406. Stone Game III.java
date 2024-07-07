class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        long sum = 0L;
        for(int val: stoneValue){
            sum += val;
        }

        Integer[][] dp = new Integer[n][2];

        int aliceScore = calculateScore(stoneValue, n, 0, 0, dp);
        long bobScore = sum - aliceScore;
        if(aliceScore > bobScore){
            return "Alice";
        } else if(aliceScore < bobScore){
            return "Bob";
        } else{
            return "Tie";
        }
    }

    // returns Alice's score
    int calculateScore(int[] stoneValue, int n, int i, int turn, Integer[][] dp) {
        if (i == n) {
            return 0;
        }

        if(dp[i][turn] != null){
            return dp[i][turn];
        }
        // Alice's turn
        if (turn == 0) {
            int maxScore = Integer.MIN_VALUE;
            int score = 0;
            for (int pile = 1; pile <= Math.min(3, n-i); pile++) {
                score += stoneValue[i + pile - 1];
                maxScore = Math.max(maxScore, score + calculateScore(stoneValue, n, i + pile, 1, dp));
            }
            return dp[i][turn] = maxScore;
        } else { // Bob's turn
            int minScore = Integer.MAX_VALUE;
            int score = 0;
            for (int pile = 1; pile <= Math.min(3, n-i); pile++) {
                score += stoneValue[i + pile - 1];
                minScore = Math.min(minScore, calculateScore(stoneValue, n, i + pile, 0, dp));
            }
            return dp[i][turn]= minScore;
        }
    }
}
