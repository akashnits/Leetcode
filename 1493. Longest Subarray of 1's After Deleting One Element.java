class Solution {
    public int longestSubarray(int[] nums) {
        int start=0, end =0;
        int zeroes = 0;
        int res =0;

        while(end < nums.length){
            // check if incoming element is 0 or 1
            if(nums[end] == 0){
                zeroes++;
            }

            // check if the window is invalid, if yes shrink it until it becomes valid again
            while(zeroes > 1){
                if(nums[start] == 0){
                    zeroes--;
                }
                start++;
            }

            res = Math.max(res, end-start);
            end++;
        }
        return res;
    }
}
