class Solution {
    public long minimumReplacement(int[] nums) {
        // start from end so that suffix array is sorted
        // we breakdown elements to smaller elements from the end

        int n = nums.length;
        long res = 0;
        int upperBound = nums[n-1];

        for(int j= n-2; j >=0; j--){            
            int noOfElems = nums[j] / upperBound;

            // if completely divisible - upper bound doesn't change
            if(nums[j] % upperBound != 0){
                // not completely divisible 
                // noOfElems increases by 1 and upper bound change e.g. 7 divided by 3 -> [2,2,3] -> upper bound is 2 now

                noOfElems++;
                upperBound = nums[j] / noOfElems; 
            }
            res += noOfElems-1; // number of operations is 1 less than number of elements
        }
        return res;
    }
}
