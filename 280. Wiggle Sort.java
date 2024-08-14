class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;

        for(int i=0; i < n-1; i++){
            if( i % 2 == 0 && nums[i+1] < nums[i]){
                // even index, swap only if nums[i+1] < nums[i]
                swap(nums, i+1, i);
            }else if(i % 2 == 1 && nums[i+1] > nums[i]){
                // swap if nums[i+1] > nums[i]
                swap(nums, i+1, i);
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
