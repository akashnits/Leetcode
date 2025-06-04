class Solution {
    // create an array prefixCount where prefixCount[i] is the count of nums[i] in the range [0, i]
    // which satisfies the condition :- nums[i] % modulo == k

    // we want to find subarrays (start, end] where (prefixSum[end] - prefixSum[start]) % modulo == k
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long res = 0;
        // pre-compute prefix count
        int n = nums.size();
        long[] prefixCount = new long[n];
        prefixCount[0] = (nums.get(0) % modulo == k) ? 1: 0;
        for(int i=1; i < n; i++){
            prefixCount[i] = prefixCount[i-1] + ((nums.get(i) % modulo == k) ? 1: 0);
        }

        Map<Long, Integer> map = new HashMap();
        map.put(0L, 1);

        for(int i=0; i < n; i++){
            // preSum[end] % modulo
            long currVal = prefixCount[i] % modulo;
            // preSum[start] % modulo
            long targetVal = (prefixCount[i] -k) % modulo;
            // check if you have seen it
            if(map.containsKey(targetVal)){
                res += map.get(targetVal);
            }

            // update map
            map.put(currVal, map.getOrDefault(currVal, 0) + 1);
        }
        return res;
    }
}
