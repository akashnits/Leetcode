class Solution {
    public boolean canPartition(int[] nums) {
        // totalSum
        int totalSum = 0;
        for(int num: nums){
            totalSum += num;
        }

        // edge condition
        if(totalSum % 2 == 1){
            return false;
        }

        int n = nums.length;
        int subsetSum = totalSum / 2;
        Boolean[][] dp = new Boolean[n][subsetSum+1];

        return doesSubsetExist(nums, subsetSum);
    }   

    // top -down approach
    boolean doesSubsetExist(int[] nums, int idx, int subsetSum, Boolean[][] dp){
        // base conditions:

        // return true if subset is found
        if(subsetSum == 0){
            return true;
        }

        if(idx == nums.length){
            return false;
        }

        if(dp[idx][subsetSum] != null){
            return dp[idx][subsetSum];
        }

        if(nums[idx] <= subsetSum){
            // may include or may not
            dp[idx][subsetSum] = doesSubsetExist(nums, idx+1, subsetSum - nums[idx], dp) || 
                   doesSubsetExist(nums, idx+1, subsetSum, dp);
        }else{
            // don't include
            dp[idx][subsetSum] = doesSubsetExist(nums, idx+1, subsetSum, dp);
        }
        return dp[idx][subsetSum];
    }

    // bottom up approach
    boolean doesSubsetExist(int[] nums, int subsetSum){
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][subsetSum+1];
        // initialize the matrix - first row and column
        for(int row=0; row <= n; row++){
            dp[row][0] = true;
        }

        for(int col=1; col <= subsetSum; col++){
            dp[0][col] = false;
        }

        // matrix of dimens: n * subsetSum
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < subsetSum+1; j++){
                // 0/1 knapsack
                // check if we can take the element
                if(nums[i-1] <= j){
                    // we may include or exclude
                    dp[i][j] = dp[i-1][j - nums[i-1]] || dp[i-1][j];
                }else{
                    // must exclude
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][subsetSum];
    }
}
