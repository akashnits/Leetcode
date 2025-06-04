class Solution {
    // look at the monotoncity here:
    // increasing number of elements increases the sum * size , while decreasing it decreases
    // we can apply sliding window
    public long countSubarrays(int[] nums, long k) {
        long windowSum = 0;
        int start =0, end = 0;
        long count = 0;

        int n = nums.length;
        while(end < n){
            // pick the element here
            windowSum += nums[end];

            // check if windowSum * size > k, shrink it
            while(windowSum * (end - start + 1) >= k){
                // we should shrink it
                windowSum -= nums[start];
                start++;
            } 
            // window is valid here
            count += end - start +1;
            end++;
        }
        return count;
    }
}
