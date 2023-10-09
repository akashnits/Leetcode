class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = findStartPosition(nums, 0, nums.length-1, target);
        int end = findEndPosition(nums, 0, nums.length-1, target);

        return new int[]{start, end};
    }

    int findStartPosition(int[] nums, int start, int end, int target){
        int res = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                res = mid;
                // go left to find the leftmost
                end = mid-1;
            }else if(nums[mid] > target){
                // go left
                end = mid-1; 
            }else{
                // go right
                start = mid+1;
            }
        }
        return res;
    }

    int findEndPosition(int[] nums, int start, int end, int target){
        int res = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                res = mid;
                // go right to find the rightmost
                start = mid+1;
            }else if(nums[mid] > target){
                // go left
                end = mid-1; 
            }else{
                // go right
                start = mid+1;
            }
        }
        return res;
    }
}
