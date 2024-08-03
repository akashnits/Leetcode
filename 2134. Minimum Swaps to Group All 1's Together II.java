class Solution {
    // approach: we need to group all 1's together, so sliding window size would be of size 1's count
    // calculate number of 0's each subarray ( circular as well )
    public int minSwaps(int[] nums) {
        int onesCount = 0;
        for(int num: nums){
            if(num == 1){
                onesCount++;
            }
        }

        int start =0; 
        int end = 0;
        int n = nums.length;

        int minSwaps = n;
        // keep track 0's in sliding window
        int fixedWindowZerosCount = 0;
        while(end < 2*n-1){
            if(nums[end % n] == 0 ){
                fixedWindowZerosCount++;
            }

            // check if this is a valid window
            if(end - start+1 == onesCount){
                minSwaps = Math.min(minSwaps, fixedWindowZerosCount);
                // shrink here
                if(nums[start % n] == 0){
                    // reduce zeros count as we are gonna drop it
                    fixedWindowZerosCount--;
                }
                start++;
            }
            end++;
        }
        return minSwaps == n ? 0: minSwaps;
    }
}
