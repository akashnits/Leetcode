class Solution {
    public int findPeakElement(int[] nums) {
        return binarySearchToFindPeakElement(nums, 0, nums.length-1);
    }

    int binarySearchToFindPeakElement(int[] nums, int start, int end){
        while( start <= end ){
            int mid = start + (end-start)/2;

            // figure out if mid is greater than it's neighbors
            int lN = mid == 0? Integer.MIN_VALUE : nums[mid-1];
            int rN = mid == nums.length-1? Integer.MIN_VALUE : nums[mid+1];

            if(nums[mid] > lN && nums[mid] > rN){
                // this is the peak element
                return mid;
            }else if(mid == 0){
                // we can only move right
                start = mid+1;
            }else if( mid == nums.length-1){
                // we can only move left
                end = mid-1;
            }else {
                // we move where we are more likely to find peak element
                // i.e. to the side where value is greater than nums[mid]

                if(nums[mid+1] > nums[mid]){
                    // we move right
                    start = mid+1;
                }else{
                    // we move left
                    end = mid-1;
                }
            }
        }
        return 0;
    }
}

class Solution {
    public int findPeakElement(int[] nums) {
        // boundary finding question
        int n = nums.length;
        int l = 0, r = n-1;

        // slope decide the boundary - we can eliminate the half which is decreasing ( downward slope )

        while(l < r){
            int mid = l + (r-l)/2;

            if(nums[mid] > nums[mid+1]){ // check for downward slope
                r = mid; // eliminate right half
            }else{
                l = mid+1;
            }
        }
        return l; // at last l == r
    }
}
