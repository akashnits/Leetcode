class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int n = nums.length;

        Map<Integer, Integer> windowMap = new HashMap();
        long windowSum = 0;
        long res = 0;

        while(end < n){
            // expand here
            windowSum += nums[end];
            windowMap.put(nums[end], windowMap.getOrDefault(nums[end], 0) + 1);

            // check (end -start + 1) == k
            if(end- start+1 == k){
                // we have window to validate
                if(windowMap.size() == k){
                    // we have all distinct elements
                    res = Math.max(res, windowSum);
                }
                // shrink window here to make in invalid
                // decrement sum
                windowSum -= nums[start];
                // decrement freq
                windowMap.put(nums[start], windowMap.get(nums[start]) -1);
                if(windowMap.get(nums[start]) == 0){
                    // remove it
                    windowMap.remove(nums[start]);
                }
                start++;
            }
            end++;
        }
        return res;
    }
}
