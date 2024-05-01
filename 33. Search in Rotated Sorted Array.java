class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int pivot = findPivot(nums, 0, n-1, n);

        if(nums[pivot] == target) return pivot;

        int res1 = binarySerach(nums, 0, pivot-1, target);
        int res2 = binarySerach(nums, pivot+1, n-1, target);

        return res1 == -1? res2: res1;
    }


    int binarySerach(int[] nums, int start, int end, int target){
        if(start > end){
            return -1;
        }

        int mid = start + (end - start)/ 2;

        if(nums[mid] == target){
            return mid;
        } else if(nums[mid] < target){
            // go right
            return binarySerach(nums, mid+1, end, target);
        } else{
            return binarySerach(nums, start, mid-1, target);
        }
    }


    // pivot will lie in unsorted part
    int findPivot(int[] arr, int l, int r, int n){
        while(l < r){ // to avoid infinite loop
            int mid = l+ (r-l)/2;
            
            if(arr[mid] > arr[r]){
                // right half is unsorted
                l = mid+1;
            }else{
                // left is unsorted
                r = mid; // don't do mid-1 as we haven't checked mid 
            }
        }
        // at this point r >= l
        return l;
    }
}
