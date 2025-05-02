class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int start =0, end = 0;
        int maxEle = 0;
        for(int num: nums){
            maxEle = Math.max(maxEle, num);
        }

        int maxEleCount = 0;
        long res = 0;

        while(end < n){
            if(nums[end] == maxEle){
                maxEleCount++;
            }
            // check if window map has maxEle freq >= k
            while(maxEleCount >= k){
                // count all subarrays from start .... end , end+1.. n
                res += n - end;
                // shrink the window, drop nums[start]
                if(nums[start] == maxEle){
                    maxEleCount--;
                }
                start++;
            }
            end++;
        }
        return res;
    }
}
