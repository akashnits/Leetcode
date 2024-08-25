class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        while(k-- > 0){
            // keep track of leftmost minimum idx
            int minIdx = 0;
            int min = nums[0];
            for(int i=1; i < n; i++){
                // find min
                if(nums[i] < min){
                    min = nums[i];
                    minIdx = i;
                }
            }
            // we have the minIdx, change value
            nums[minIdx] = nums[minIdx] * multiplier;
        }
        return nums;
    }
}
