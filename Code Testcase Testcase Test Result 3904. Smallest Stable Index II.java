class Solution {
    public int firstStableIndex(int[] nums, int k) {
        // dp[i] keep the max from (0, i)
        // dp[j] keeps the min from (i, n-1)
        // we do dp[i] - dp[j] and compare with k

        int n = nums.length;
        int[] dp = new int[n];
        int res = -1;

        int maxValue = 0;
        for(int i =0; i < n; i++){
            if(nums[i] > maxValue){
                maxValue = nums[i];
            }
            dp[i] = maxValue; // dp[i] contains maxValue alwats
        }

        // iteratr from the end
        int minValue = Integer.MAX_VALUE;
        for(int j=n-1; j >= 0; j--){
            if(nums[j] < minValue)
                minValue = nums[j];

            // we compute the diff between max and min valuea
            int score = dp[j] - minValue;
            if(score <= k){
                res = j;
            }    
        }

        return res;
    }
}
