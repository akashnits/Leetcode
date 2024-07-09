class Solution {
    public boolean winnerSquareGame(int n) {
        Boolean[][] dp = new Boolean[n+1][2];
        return canAliceWin(n, 0, dp);
    }

    boolean canAliceWin(int n , int turn, Boolean[][] dp){
        if(n == 0){
            return turn == 1; // it it's Bob's turn Alice wins
        }

        if(dp[n][turn] != null){
            return dp[n][turn];
        }

        // choices Alice/Bob have
        if(turn == 0){
            boolean aliceWin = false;
            // Alice's turn, she plays optimally
            for(int pile = 1; pile*pile <= n; pile++){
                int square = pile * pile;
                aliceWin = aliceWin || canAliceWin(n-square, 1, dp);
            }
            return dp[n][turn] = aliceWin;
        }else{
            // Bob's turn, he plays optimally
            boolean aliceWin = true; // alice plays sub-optimally here
            for(int pile = 1; pile*pile <= n; pile++){
                int square = pile * pile;
                // if any choice of bob leads to Alice loss, pick it
                aliceWin = aliceWin && canAliceWin(n-square, 0, dp); 
            }
            return dp[n][turn] = aliceWin;
        }
    }
}
