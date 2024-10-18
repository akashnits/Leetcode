class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOR = 0;

        for(int num: nums){
            maxOR |= num;
        }

        int n = nums.length;

        Integer[][] dp = new Integer[n][maxOR+1];

        return solve(nums, 0, 0, maxOR, dp);
    }

    int solve(int[] nums, int i, int currOR, int maxOR, Integer[][] dp){  
        if( i == nums.length){
            return currOR == maxOR ? 1: 0;
        }

        if(dp[i][currOR] != null){
            return dp[i][currOR];
        }

    
        // include or exclude 
        dp[i][currOR] = solve(nums, i+1, currOR | nums[i], maxOR, dp) + 
                solve(nums, i+1, currOR, maxOR, dp);
        return dp[i][currOR];
    }
}
