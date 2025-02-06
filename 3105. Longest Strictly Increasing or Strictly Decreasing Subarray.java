class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        // keep track of longestIncreasingSubarray and longestDecresingSubarray
        int currLis = 1;
        int currLds = 1;

        int maxLengthLIS = 1;
        int maxLengthLDS = 1;

        int n = nums.length;

        for(int i=1; i < n; i++){
            // for finding lis
            if(nums[i] > nums[i-1]){
                // it's increasing
                maxLengthLIS = Math.max(maxLengthLIS, ++currLis);
            }else{
                // reset it
                currLis = 1;
            }

            /// for finding lds
            if(nums[i] < nums[i-1]){
                // decreasing
                maxLengthLDS = Math.max(maxLengthLDS, ++currLds);
            }else{
                currLds = 1;
            }
        }

        return Math.max(maxLengthLIS, maxLengthLDS);
    }
}
