class Solution {
    // Imp: Use DNF sort - Dutch national flag sort - https://www.youtube.com/watch?v=2C4CQ32961Y
    // use three pointers - low, mid, high
    // low keeps track of 0's , mid 1's, high 2's
    public void sortColors(int[] nums) {
        int low =0, mid = 0;
        int high = nums.length-1;
        
        while(mid <= high){
            
            if(nums[mid] == 0){
                // swap with low
                swap(nums, mid, low);
                low++;
                mid++;
            }else if(nums[mid] == 1){
                mid++;
            }else{
                //swap with high
                swap(nums, mid, high);
                high--;
            }
        }
    }
    
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] =temp;
    }
}
