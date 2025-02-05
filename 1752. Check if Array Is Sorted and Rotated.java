class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        
        if(n == 1){
            return true;
        }

        // check if given nums is already sorted
        if(isSorted(nums, 0)){
            return true;
        }

        // step 1: find the element which is smaller than prev
        int pivot = 1;
        while(pivot < n){
            if(nums[pivot] < nums[pivot-1]){
                break;
            }else{
                pivot++;
            }
        }

        // step 2: check if remaining elements are sorted
        boolean isSorted = isSorted(nums, pivot);
        

        // step 3: compare last element with first 
        return isSorted && (nums[0] >= nums[n-1]);
    }

    private boolean isSorted(int[] nums, int idx){
        int n = nums.length;
        for(int i=idx+1; i < n; i++){
            if(nums[i] < nums[i-1]){
                return false;
            }
        }
        return true;
    }
}
