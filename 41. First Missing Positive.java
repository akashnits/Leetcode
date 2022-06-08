class Solution {
    public int firstMissingPositive(int[] nums) {
        // idea is check if an element is at correct postiion , if not swap 
        // nums[i]-1 should be at i 
        
        int n= nums.length;
        for(int i=0; i < n; i++){
            if(nums[i]-1 == i){
                // it's at corect position
                continue;
            } else if(nums[i]-1 < 0 || nums[i]-1 > n-1){
                // no place for this in array
                continue;
            }else {
                // there's a place for this element, we need to find the correct index
                int correctIdx = nums[i]-1;
                // only swap if elements are different at idxs
                if(nums[i] == nums[correctIdx]) continue;
                // swap element at i with correct index
                swap(nums, i, correctIdx);
                // decrement so that we check if element is at correct place after swap
                i--;
            }
        }
        
        // iterate through the array now and find the first element which is out of place
        
        // and return correct number i+1
        
        for(int i=0; i < n; i++){
            if(nums[i]-1 != i){
                return i+1;
            }
        }
        
        return n+1;
    }
    
    public void swap(int[] nums, int a, int b){
        int temp= nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
