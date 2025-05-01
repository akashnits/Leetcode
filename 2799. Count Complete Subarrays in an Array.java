class Solution {
    public int countCompleteSubarrays(int[] nums) {
        // calculate distinct elements
        int n = nums.length;
        Set<Integer> set = new HashSet();
        for(int num: nums){
            set.add(num);
        }

        int validWindowLen = set.size();
        int start = 0, end = 0;
        
        Map<Integer, Integer> windowMap = new HashMap();
        int res = 0;
        while( end < n ){
            // include this value
            windowMap.put(nums[end], windowMap.getOrDefault(nums[end], 0) +1);

            // check if this is valid window, calculate number of subarrays
            while(windowMap.size() == validWindowLen){
                res += n - end;
                // we want to shrink the window now by sliding ahead start+1
                windowMap.put(nums[start], windowMap.get(nums[start]) -1);
                if(windowMap.get(nums[start]) == 0){
                    windowMap.remove(nums[start]);
                }
                start++;
            }
            end++;
        }
        return res;
    }
}
