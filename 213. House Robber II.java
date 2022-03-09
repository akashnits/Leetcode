// state variables:
// house; canRob -> 0,1, canRobLast -> 0,1
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[][][] dp  = new int[nums.length][2][2];
        for(int[][] matrix: dp){
            for(int[] row: matrix){
                Arrays.fill(row, -1);
            }
        }
        
        return Math.max(solve(nums, 0, 0, 1, dp), solve(nums, 0, 1, 0, dp));
    }
    
    private int solve(int[] nums, int i, int canRob, int canRobLast, int[][][] dp){
        
        // base condition
        if(i == nums.length){
            return 0;
        }
        
        if( i == nums.length-1){
            if(canRob == 1){
                dp[i][canRob][canRobLast] =  canRobLast == 1? nums[i]: 0;
            }else{
                dp[i][canRob][canRobLast] = 0;
            }
            return dp[i][canRob][canRobLast];
        }
        
        if(dp[i][canRob][canRobLast] != -1){
            return dp[i][canRob][canRobLast];
        }
        // choice diagram
        if(canRob == 1){
            // we may rob
            dp[i][canRob][canRobLast] =  Math.max(nums[i] + solve(nums, i+1, 0, canRobLast, dp), solve(nums, i+1, 1, canRobLast, dp));
            return dp[i][canRob][canRobLast];
        }else{
            // we can't rob, do nothing
            dp[i][canRob][canRobLast] = solve(nums, i+1, 1, canRobLast, dp);
            return dp[i][canRob][canRobLast];
        }
        
    }
}
