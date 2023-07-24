class Solution {
    public int rob(int[] nums) {
        // dp array represents maximum profit at index i
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }

        
        return Math.max(maximizeProfit(nums, true), maximizeProfit(nums, false));
        // int[][] memo = new int[n][2];
        // for(int[] row: memo){
        //     Arrays.fill(row, -1);
        // }
        
        // return Math.max(calculateMaxProfit(nums, n-2, 1, memo), calculateMaxProfit(nums, n-1, 0, memo));
    }

    int maximizeProfit(int[] nums, boolean canRobLast){

        int[] dp = new int[nums.length];

        dp[0] = canRobLast ? 0 : nums[0]; // can't rob first
        dp[1] = canRobLast ? nums[1] : Math.max(nums[0], nums[1]); 


        int n = canRobLast ? nums.length : nums.length-1;

        for(int i=2; i < n; i++){
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }

        return dp[n-1];
    }

    // using memo
    int calculateMaxProfit(int[] nums, int idx, int canRobFirst, int[][] memo){
        if(idx < 0 ){
            return 0;
        }

        if(idx == 0){
            return canRobFirst == 1 ? nums[0]: 0 ;
        }

        if(idx == 1){
            return canRobFirst == 1 ? Math.max(nums[0], nums[1]) : nums[1];
        }

        if(memo[idx][canRobFirst] != -1){
            return memo[idx][canRobFirst];
        }

        memo[idx][canRobFirst] = Math.max(nums[idx] + calculateMaxProfit(nums, idx-2, canRobFirst, memo), 
                        calculateMaxProfit(nums, idx-1, canRobFirst, memo));
        return memo[idx][canRobFirst];              
    }
}
