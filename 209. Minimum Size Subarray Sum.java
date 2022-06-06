class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int lo=0, hi=1;
        int sum= nums[0];
        int length = hi-lo+1;
        int minLength = (sum >= target) ? 1: n+1;
        
        while(hi < n){
            sum += nums[hi];
            
            while( sum >= target){
                // we shrink
                sum -= nums[lo];
                minLength = Math.min(minLength, hi-lo+1);
                lo++;
            }
            hi++;
        }
        
        return minLength == n+1 ? 0 : minLength;
    }
}
