class Solution {

    /*
    For every possible number of stones I can take:
    score = what I gain right now

    opponentAdvantage = how much the opponent
                        can beat me by afterward

    myAdvantage = score - opponentAdvantage

    choose the move giving me the largest advantage. 
    
    advantantage = myScore - solve( ..., j+1, ...)
    */

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;

        Integer[] dp = new Integer[n]; // max score differnce between players

        int maxDiffScore = calculateMaxDiffScore(stoneValue, n, 0, dp);

        if (maxDiffScore > 0) {
            return "Alice";
        } else if (maxDiffScore < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

    int calculateMaxDiffScore(int[] nums, int n, int idx, Integer[] dp) {
        // base condition:
        if (idx >= n) {
            return 0;
        }

        if (dp[idx] != null) {
            return dp[idx];
        }

        // alice has three choices and she picks the one which maximizes the score
        int maxDiffScore = Integer.MIN_VALUE;

        int currScore = 0;
        // alice takes 1/2/3 stones and recurse on it's decision to find maxScore
        for (int j = idx; j < Math.min(idx + 3, n); j++) {
            currScore += nums[j];
            // score diff between alice and bob's score

            maxDiffScore = Math.max(maxDiffScore, currScore - calculateMaxDiffScore(nums, n, j+1, dp));
        }
        dp[idx] = maxDiffScore;

        return dp[idx];
    }
}
