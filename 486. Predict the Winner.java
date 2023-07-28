class Solution {
    // approach: calculate score for player 1 and decide
    public boolean PredictTheWinner(int[] nums) {
        long totalScore = 0L;
        for(int num: nums){
            totalScore += num;
        }
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        int  player1Score = calculateScore(nums, 0, n-1, dp);
        return player1Score >= totalScore - player1Score;
    }


    int calculateScore(int[] nums, int start, int end, int[][] dp){

        if(start > end ){
            return 0;
        }

        if(start == end){
            return nums[start];
        }

        if(dp[start][end] != -1){
            return dp[start][end];
        }


        dp[start][end] =  Math.max(nums[start] + Math.min(calculateScore(nums, start+2, end, dp), calculateScore(nums, start+1, end-1, dp)), 
                                   nums[end] + Math.min(calculateScore(nums, start, end-2, dp), calculateScore(nums, start+1, end-1, dp)));
        return dp[start][end];                
    }
}
