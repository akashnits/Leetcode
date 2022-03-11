class Solution {
    // Approach:
    // Example: [5,-2,-3,4,-2,5]
    // we need to find max subarray sum for all of above arrays and return max
    // Output for above example is: 12 -> [4,-2,5,5]
    // Answer could be one of the following:
    // 1. max subarray non-circular
    // 2. max subarray circular - don't include some elements from the middle
    // this concludes that some elements from the middle add up to -ve value
    // we want to maximize -ve value i.e. we need to find min subarray
    //  max subarray circular = sum - min_subarray 
    // result = max(max subarray non-circular, max subarray circular)
    
    
    
    public int maxSubarraySumCircular(int[] nums) {
        int sum=0;
        for(int num: nums){
            sum += num;
        }
        int maxSubArrayNC = maxSubArray(nums);
        int maxSubArrayC = sum - minSubArray(nums);
        return maxSubArrayNC > 0 ? Math.max(maxSubArrayNC,maxSubArrayC ): maxSubArrayNC;
    }
    
    private int maxSubArray(int[] nums){
        //kadane's algo
        int max = nums[0];
        int curr= nums[0];
        
        for(int i=1; i< nums.length; i++){
            curr = Math.max(nums[i], nums[i]+curr);
            max = Math.max(curr, max);
        }
        return max;
    }
    
    private int minSubArray(int[] nums){
        int min = nums[0];
        int curr = nums[0];
        
        for(int i=1; i< nums.length; i++){
            curr = Math.min(nums[i], nums[i]+curr);
            min = Math.min(curr, min);
        }
        return min;
    }
}
