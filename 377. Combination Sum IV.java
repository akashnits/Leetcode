class Solution {
    public int combinationSum4(int[] nums, int target) {
       int[] dp = new int[target+1];
        Arrays.fill(dp, -1);
       return solve(nums, target, dp);
    }
    
    int solve(int[] nums, int targetSum, int[] dp){
        
        // base condition
        if(targetSum < 0){
            return 0;
        }
        if(targetSum == 0){
            dp[targetSum] =1;
            return 1;
        }
        
        if(dp[targetSum] != -1){
            return dp[targetSum];
        }
        
        int result=0;
        
        // loop over choices
        for(int i=0; i < nums.length; i++){
            result += solve(nums, targetSum-nums[i], dp);
            dp[targetSum] = result;
        }
        return result;
    }
}
