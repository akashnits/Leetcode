class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // how do we quickly count subarrays for a valid window
        //  number of subarrays ending at (end) = end- start + 1, why ?

        // for a subarray ending at end, start could be [start, start+1, start+2... end]

        // number of start points = end - start +1;
        // number of start points == number of subarrays

        return atMostK(nums, k) - atMostK(nums, k-1);
    }

    private int atMostK(int[] nums, int k){
        Map<Integer, Integer> freqMap = new HashMap();
        int res = 0;
        int start = 0;
        int end =0;
        int n = nums.length;
        while(end < n){
            // expand here
            freqMap.put(nums[end], freqMap.getOrDefault(nums[end], 0) +1);

            // check window validity - invalid window if distinct elements count > k
            while(freqMap.size() > k){
                freqMap.put(nums[start], freqMap.get(nums[start]) - 1);

                if(freqMap.get(nums[start]) == 0){
                    freqMap.remove(nums[start]);
                }
                start++;
            }

            // we have a valid window here
            res += end - start + 1 ; // number of subarrays = window length
            end++;
        }
        return res;
    }
}
