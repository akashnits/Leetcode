class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> windowMap = new HashMap();

        int start = 0, end = 0;
        int n = nums.length;

        int longest = 0;
        while(end < n){
            // we expand here - try taking the element
            windowMap.put(nums[end], windowMap.getOrDefault(nums[end], 0) + 1);

            // check if want to shrink i.e. any element freq > k
            while(windowMap.get(nums[end]) > k){
                // we start shrinking
                windowMap.put(nums[start], windowMap.get(nums[start]) -1);
                if(windowMap.get(nums[start]) == 0)
                    windowMap.remove(nums[start]);
                start++;
            }

            
            longest = Math.max(longest, end - start +1);
            
            end++;
        }
        return longest;     
    }
}
