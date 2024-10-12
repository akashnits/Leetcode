class Solution {
    public boolean divisorGame(int n) {
        Integer[][] dp = new Integer[n+1][2];
        
        
        return aliceTurnCount(n, 0, dp) > 0; // alice turn should be greater than 1 i.e. Alice should make the last move
    }
    
    
    
    int aliceTurnCount(int n, int turn, Integer[][] dp){
        // base condition
        // if any of the player couldn't play
        if(n <= 1){
            return 0; // can't play this
        }
        
        if(dp[n][turn] != null){
            return dp[n][turn];
        }
        
        // choice - depends on player's turn
        int maxTurns = 0;
        if(turn == 0){
            // alice's turn for optimal move
            // loop through all Alice's choices and find the optimal one
            for(int x=1; x < n; x++){
                if(n % x != 0){
                    // can;t make this move
                    continue;
                }
                // recurse
                maxTurns = Math.max(maxTurns, 1 + aliceTurnCount(n-x, 1, dp)) ;
            }
        }else{
            // suboptimal move for alice, minimize alice turns
            for(int x=1; x < n; x++){
                if(n % x != 0){
                    // can;t make this move
                    continue;
                }
                // recurse
                maxTurns = Math.min(maxTurns, -1 + aliceTurnCount(n-x, 0, dp)) ;
            }
        }
        return dp[n][turn] = maxTurns;
    }
}
