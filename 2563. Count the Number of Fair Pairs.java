class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        // create a pair array
        int n = nums.length;
        Arrays.sort(nums);
        long res = 0;
        // loop over the array from end to start
        for(int i=n-1; i > 0; i--){
            // try finding pair in the range 0..i-1
            int lowerVal = lower - nums[i];
            int upperVal = upper - nums[i];

            // find next greater for lower value; next smaller for upper value
            int lowerIdx = equalOrNextGreater(nums, 0, i-1, lowerVal);
            int upperIdx = equalOrNextSmaller(nums, 0, i-1, upperVal);

            // none of the lowerIdx or upperIdx should be invalid
            if(lowerIdx > upperIdx){
                continue;
            }else{
                res += upperIdx - lowerIdx + 1;
            }
        }
        return res;
    }

    int equalOrNextGreater(int[] nums, int l, int r, int val){
        while(l <= r){
            int mid = l + (r - l)/2;
            if(nums[mid] >= val){
                // move left
                r = mid-1;
            }else{
                // move right
                l = mid+1;
            }
        }
        return l;
    }

    int equalOrNextSmaller(int[] nums, int l, int r, int val){
        while(l <= r){
            int mid = l + (r - l)/2;
            if(nums[mid] <= val){
                // move right
                l = mid+1;
            }else{
                // move left
                r = mid-1;
            }
        }
        return r;
    }

}
