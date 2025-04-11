class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        Arrays.fill(dp, -1);
        return solveForMaxPoints(questions, n, 0, dp);
    }


    long solveForMaxPoints(int[][] questions, int n, int idx, long[] dp){
        // base condition:
        if(idx >= n){
            return 0;
        }

        if(dp[idx] != -1){
            return dp[idx];
        }

        // choices we have: we may solve it or skip it
        long include = questions[idx][0] + 
                        solveForMaxPoints(questions, n, idx + questions[idx][1] + 1, dp);
        long skip = solveForMaxPoints(questions, n, idx +1, dp);

        return dp[idx] = Math.max(include, skip);
    }
}
