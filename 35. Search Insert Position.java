class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        return binarySearch(nums, 0, n-1, target);
    }

    int binarySearch(int nums[], int start, int end, int target){
        if(start > end){
            // we couldn't find the index, so return the index of next greater
            return start;
        }


        int mid = start + (end - start)/2;
        if(nums[mid] == target){
            return mid;
        } else if(nums[mid] > target){
            // go left
            return binarySearch(nums, start, mid-1, target);
        }else{
            // go right
            return binarySearch(nums, mid+1, end, target);
        }
    }
}
