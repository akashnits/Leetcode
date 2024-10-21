/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index);
 *     public int length();
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int peak = findPeak(mountainArr, n);
        
        // Try to find the target in the increasing part
        int result = binarySearch(mountainArr, target, 0, peak, true);
        if (result != -1) {
            return result;
        }
        
        // If the target is not found in the increasing part, search in the decreasing part
        return binarySearch(mountainArr, target, peak + 1, n - 1, false);
    }
    
    // Function to find the peak element in the mountain array
    int findPeak(MountainArray mountainArr, int n) {
        int start = 0, end = n - 1;
        
        while(start <= end){
            int mid = start + (end - start) / 2;

            int prev = mid == 0 ? Integer.MIN_VALUE : mountainArr.get(mid-1);
            int next = mid == n-1 ? Integer.MIN_VALUE : mountainArr.get(mid+1);

            int valAtMid = mountainArr.get(mid);
        
            if(valAtMid > prev && valAtMid > next){
                return mid; // peak element
            }else if(next > valAtMid){ // peak lies in increasing slope
                // go to right
                start = mid+1;
            } else{
                // go to left
                end = mid-1;
            }
        }
        return -1; // not possible as we would find the peak element always 
    }
    
    // Binary search function
    int binarySearch(MountainArray mountainArr, int target, int start, int end, boolean ascending) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midVal = mountainArr.get(mid);
            
            if (midVal == target) {
                return mid;
            }
            
            if (ascending) {
                if (midVal < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (midVal > target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        
        return -1;
    }
}
