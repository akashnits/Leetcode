class Solution {
    public int countSubarrays(int[] nums) {
        // 2 * sum == third
        // sliding window if size 3
        int start =0, end = 0;
        int n = nums.length;

        int count =0;
        while(end < n){
            // check if valid window
            if(end-start+1 == 3){
                // check if condition holds
                if(conditionHolds(nums[start], nums[start+1], nums[end])){
                    count++;
                }
                start++;
            }
            end++;
        }
        return count;
    }

    boolean conditionHolds(int first, int second, int third){
        return (2 * (first + third)) == second;
    }
}
