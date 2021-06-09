class Solution {
    //Idea: think of this question as finding the count of subset which
    //sums to (sumOfNums + target)/2
    
    //explanation: we need to put signs in front of elements which is same partitioning array in two parts such that their difference equals target
    
    // s1 - subset 1, s2 - subset 2
    // s1+s2= sumOfNums, s1-s2= target
    //adding above equations : 2s1 = (sumOfNums + target) => s1 = (sumOfNums + target)/2 
    //Note:- (sumOfNums + target) should be completely divisible by 2, else return 0
    //Hence, finding the count of s1 is the answer
    
    public int findTargetSumWays(int[] nums, int target) {
            int N = nums.length;
            int sum = 0;
            int count =0;
            for(int ele: nums){
                //sum it all
                sum = sum + ele;
                if(ele == 0)
                    count++;
            }
            //boundary condition
            if(target > sum || ((target+sum) % 2 != 0)){
                return 0;
            }
            //need a initialized dp array
            int[][] dp= new int[N+1][sum+1];
            for (int i = 0; i < N+1; i++)
                dp[i][0] = 1;
 
            for (int i = 1; i < sum+1; i++)
                dp[0][i] = 0;
        
            int sumToFind = (sum + target)/2;
            return countSubsetSum(nums, N, sumToFind, dp, count);
    }
    
    public int countSubsetSum(int[] nums, int n, int sum, int[][] dp, int count){
        for(int i=1; i< n+1; i++){
                for(int j=1; j< sum+1; j++){
                    if(nums[i-1]==0)
                        dp[i][j] = dp[i-1][j];
                    else if(j < nums[i-1])
                        dp[i][j] = dp[i-1][j];
                    else
                        dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                }
        }
        return (int)(Math.pow(2.0, count)) * dp[n][sum];
	}
}
