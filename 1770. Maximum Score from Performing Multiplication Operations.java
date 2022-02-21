class Solution {
    int m, n;
    //recursive approach converted to Top-down dp
    public int maximumScore(int[] nums, int[] multipliers) {
        m = multipliers.length;
        n = nums.length;
    
        // state variables are i, left and right
        // right can be re-written as:  n-1 -(i-left)
        
        int[][] dp = new int[m][m];
        return solve(0, 0, nums, multipliers, dp);
    }
    
    
    private int solve(int i, int left, int[] nums, int[] multipliers, int[][] dp){
        // base condition 
        if(i == m){
            return 0;
        }

        int right = n-1 - (i-left);
        // recurrence equation: 
        if(dp[i][left] == 0){   
            dp[i][left] = Math.max( nums[left] * multipliers[i] + solve(i+1, left+1, nums, multipliers, dp), 
            nums[right] * multipliers[i] + solve(i+1, left, nums, multipliers, dp) );
        }
        return dp[i][left];
    }
}
