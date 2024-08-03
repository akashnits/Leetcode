class Solution {
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
        while(end < n){
            if(nums[end] == 0 ){
                fixedWindowZerosCount++;
            }

            // check if this is a valid window
            if(end - start+1 == onesCount){
                minSwaps = Math.min(minSwaps, fixedWindowZerosCount);
                // shrink here
                if(nums[start] == 0){
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
