class Solution {
    public int lengthOfLIS(int[] nums) {
        
        return solve(nums, Integer.MAX_VALUE, nums.length);
    }
    
    private int solve(int[] nums, int prev, int n){
        // base condition
        if(n == 0){
            return 0;
        }
        
        // choice diagram
        
        if(nums[n-1] < prev){
            // we may/may not include this
            
            return Math.max(1 + solve(nums, nums[n-1], n-1), solve(nums, prev, n-1));
        }else{
            return solve(nums, prev, n-1);
        }
    }
}
