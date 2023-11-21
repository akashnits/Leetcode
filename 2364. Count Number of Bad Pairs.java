class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long totalPair = totalpair(n);
        long goodPair = goodPair(nums, n);

        return totalPair- goodPair;
    }

    long totalpair(int n){
        long res = 0;
        while(n > 1){
            res += --n;
        }
        return res;
    }

    long goodPair(int[] nums, int n){
        long res = 0;
        int diff = 0;
        Map<Integer, Long> freqMap = new HashMap();
        for(int i=0; i < n; i++){
            diff = nums[i]-i;
            res = res + freqMap.getOrDefault(diff, 0L);
            freqMap.put(diff, freqMap.getOrDefault(diff, 0L) + 1);
        }
        return res;
    }

}
