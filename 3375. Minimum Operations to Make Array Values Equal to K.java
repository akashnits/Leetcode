class Solution {
    public int minOperations(int[] nums, int k) {
        // sort the array 
        Arrays.sort(nums);

        int n = nums.length;

        // edge case - if k > first element, no solution
        if(k > nums[0]){
            return -1;
        }

        // count number of groups
        int count =0;
        for(int i=n-1; i >=0; i--){
            while(i > 0 && nums[i-1] == nums[i]){
                i--;
            }
            count++;
        }

        return k == nums[0] ? count-1: count;
    }
}
