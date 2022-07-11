class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        return binarySearch(arr, 0, arr.length-1, arr.length);
    }
    
    private int binarySearch(int[] arr, int l, int r, int n){
        if(l > r){
            return -1;
        }
        
        int mid = l + (r-l)/2;
        
        
        int prev = mid == 0? n-1: mid-1;
        int next = mid == n-1? 0: mid+1;
       
            if(arr[mid] > arr[prev] && arr[mid] > arr[next]){
                return mid;
            }else if(arr[next] > arr[mid]){
                // move right
                return binarySearch(arr, mid+1, r, n);
            }else{
                // move left
                return binarySearch(arr, l, mid-1, n);
            }
            
        
        
    }
}
