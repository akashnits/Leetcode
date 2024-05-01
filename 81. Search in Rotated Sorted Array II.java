public class Solution {

    public boolean search(int[] nums, int target) {
        int n = nums.length;
        
        int p = findPivot(nums, 0 , n-1, n);
        
        if(nums[p] == target) {
            return true;
        }
        
        return binarySearch(nums, 0, p-1, target) || binarySearch(nums, p+1, n-1, target);
    }

    // pivot will lie in unsorted part
    int findPivot(int[] arr, int l, int r, int n){
        while(l < r){ // to avoid infinite loop

            // how to skip duplicates ?
            // we shrink the array

            while(l < r && arr[l] == arr[l+1]){
                l++;
            }

            while( l < r && arr[r] == arr[r-1]){
                r--;
            }

            int mid = l+ (r-l)/2;
            
            if(arr[mid] > arr[r]){
                // right half is unsorted
                l = mid+1;
            }else{
                // left is unsorted
                r = mid; // don't do mid-1 as we haven't checked mid 
            }
        }
        // at this point r == l
        return l;
    }
    
    public boolean binarySearch(int[] nums, int l, int r, int target) {
        while(l <= r) {
            int mid = l + (r-l)/2;
            
            if(nums[mid] == target)
                return true;
            
            if(nums[mid] < target)
                l = mid+1;
            else
                r = mid-1;
        }
        
        return false;
    }
}
