class Solution {
    public long countGood(int[] nums, int k) {
        int start = 0;
        int end = 0;
        long res = 0;
        int n = nums.length;
        Map<Integer, Integer> windowMap = new HashMap();
        int windowPairCount = 0;

        while(end < n){
            // take the value here
            windowMap.put(nums[end], windowMap.getOrDefault(nums[end], 0) + 1);
            // count pairs now
            int freq = windowMap.get(nums[end]);
            if(freq >= 2){
                // we have repetition i.e. pairs
                windowPairCount += freq-1;
            }

            // check if we have valid window i.e. windowPairCount >= k
            while(windowPairCount >= k){
                // we count the number of subarrays
                // we add (n - end) coz all subsequent arrays would be valid as well from end
                res += n - end;
                // we now shrink the window and adjust pairs count
                int startFreq = windowMap.get(nums[start]);
                windowPairCount -= startFreq-1;
                windowMap.put(nums[start], startFreq -1);
                start++;
            }
            end++;
        }

        return res;
    }
}
