class Solution {
    public void nextPermutation(int[] nums) {
        //Idea: A strictly decreasing sequence is last permutation lexicographically
        // Step 1: Find strictly decreasing sequence or iterate from right to left ( we want longer prefix )
        // and find a point where sequence is not ascending
        // if not found, reverse the sequence and return
        //e.g. 6,2,1,5,4,3
        // 1 is the value where a[i] < a[i+1], say it's pivot
        
        //Step 2: Swap value at that point (pivot) with number JUST greater than that value
        //iterate from right to left and first number which is JUST greater that value
        //swap them
        //6,2,1,5,4,3 -> 6,2,3,5,4,1 ; swap 1 with 3 as 3 is the next greater value to 1
        // now we have a greater number but is it next greater? NO
        
        //Step 3: 6,2,3,5,4,1 - we observe that 5, 4, 1 is strictly decreasing sequence, which means it's the last sequence of permutaion
        // What's the first sequence ? Reverse the last sequence of permutation, this would be the first sequence of permutaion
        // 6,2,3,5,4,1 -> 6,2,3,1,4,5
        
        
        // key observations:
        // 1. Two values who are neigbhors would have near equal prefixes, so we from right to left
        // 2. A strictly decreasing sequence is last permutation lexicographically, we can't get a greater value using this
        // 3. Reversing the strictly decreasing sequence gives smallest strictly increasing sequence
        
        int pivot = -1;

        for(int i=nums.length-1; i > 0; i--){
            if(nums[i] > nums[i-1]){
                pivot= i-1;
                break;
            }
        }
        
        if(pivot == -1){
            // no strictly decreasing sequence found
            reverse(nums, 0, nums.length-1);
            return;
        }
        
        for(int i=nums.length-1; i >= 0; i--){
            if(nums[pivot] < nums[i]){
                //swap 
                int temp= nums[i];
                nums[i]= nums[pivot];
                nums[pivot]= temp;
                break;
            }
        }
        //reverse the array from k+1 to end
        reverse(nums, pivot+1, nums.length-1);        
    }
    
    private void reverse(int[] array, int start, int end){
        while(start < end){
            int temp= array[start];
            array[start]= array[end];
            array[end]= temp;
            start++;
            end--;
        }
    }
    
}
