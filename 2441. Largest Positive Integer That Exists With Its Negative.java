class Solution {
    public int findMaxK(int[] nums) {
        // two pointer technique
        int n = nums.length;
        int i=0, j = n-1;

        Arrays.sort(nums);

        while(i < j){

            if(nums[j] < 0 || nums[i] > 0){
                break;
            }
            if(-nums[i] == nums[j]){
                return nums[j];
            }
            // nums[j] could be lesser or greater
            if(nums[j] < Math.abs(nums[i])){
                // move start pointer
                i++;
            }else{
                j--;
            }

        }
        return -1;
    }
}
