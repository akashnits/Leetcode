class Solution {
    //Using top-down approach
    // for dividing a array into two equal parts is same as
    // finding a subset which sums to arraySum/2
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i= 0; i< nums.length; i++){
            sum  = sum + nums[i];
        }
        
        if(sum % 2 != 0){
            return false;
        }else{
            int sumToFind= sum/2;
            return subsetSum(nums, nums.length, sumToFind, new boolean[nums.length+1][sumToFind+1]);
        }
    }
    
    boolean subsetSum(int[] nums, int n, int sum, boolean[][] dp){
        //intialize dp array
        //initialize(dp, n, sum);
        dp[0][0] = true;
        //choices
        for(int i = 1; i < n+1; i++){
            for(int j =1; j< sum+1; j++){
                if(nums[i-1] <= j){
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j]= dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
    
    void initialize(boolean[][] dp, int n, int sum){
        for(int i=0; i< n; i++){
            for(int j=0; j< sum; j++){
                if( i == 0 && j == 0 ){
                    dp[i][j] = true;
                }else if( j==0 ){
                    //iterating first column
                    dp[i][j] = true;
                }else if( i ==0 ){
                    //iterating first row
                    dp[i][j]= false;
                }
            }
        }
    }
}
