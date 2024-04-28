class Solution {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        Integer[][] dp = new Integer[n][m];
        
        return findMinTotalStepsToReach(ring, key, 0, 0, dp);
    }

    int findMinTotalStepsToReach(String ring, String key, int ringIdx, int keyIdx, Integer[][] dp){
        if(keyIdx == key.length()){
            return 0;
        }

        if(dp[ringIdx][keyIdx] != null){
            return dp[ringIdx][keyIdx];
        }

        char keyChar = key.charAt(keyIdx);
        int minTotalSteps = Integer.MAX_VALUE;

        // find the position of this char on ring
        for(int i=0; i < ring.length(); i++){
            if(ring.charAt(i) == keyChar){
                int antiDistance = Math.abs(i - ringIdx);
                int distance = ring.length() - antiDistance;

                // two options, either we can go clockwise or anti-clockwise

                int clockwiseSteps = 1 + distance + findMinTotalStepsToReach(ring, key, i, keyIdx+1, dp);
                int antiClockwiseSteps =  1 + antiDistance + findMinTotalStepsToReach(ring, key, i, keyIdx+1, dp);              
                minTotalSteps = Math.min(minTotalSteps,  Math.min(clockwiseSteps, antiClockwiseSteps));
                dp[ringIdx][keyIdx] = minTotalSteps;
            }
        }
        return minTotalSteps;
    }
}
