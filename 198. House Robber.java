class Solution {
    public int rob(int[] nums) {
        // dp array represents maximum profit at index i
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }

        // int[] dp = new int[n];
        // dp[0] = nums[0];
        // dp[1] = Math.max(nums[0], nums[1]);

        // for(int i=2; i < n; i++){
        //     dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        // }

        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return calculateMaxProfit(nums, n-1, memo);
    }

    // using memo
    int calculateMaxProfit(int[] nums, int idx, int[] memo){
        if(idx < 0 ){
            return 0;
        }

        if(idx == 0){
            return nums[0];
        }

        if(idx == 1){
            return Math.max(nums[0], nums[1]);
        }

        if(memo[idx] != -1){
            return memo[idx];
        }

        memo[idx] = Math.max(nums[idx] + calculateMaxProfit(nums, idx-2, memo), 
                        calculateMaxProfit(nums, idx-1, memo));
        return memo[idx];              
    }
}
