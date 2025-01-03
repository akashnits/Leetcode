class Solution {
    public int waysToSplitArray(int[] nums) {
        // preSum
        int n = nums.length;
        long preSum = 0;

        long totalSum = 0;
        for(int num: nums){
            totalSum += num;
        }

        // loop through and find places where preSum >= postSum
        int res = 0;
        for(int j=0; j < n-1; j++){
            preSum += nums[j];
            if(preSum >= totalSum - preSum){
                res++;
            }
        }
        return res;
    }
}
