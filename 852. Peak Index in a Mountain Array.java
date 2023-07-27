class Solution {
    // need to find localMax i.e. arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]
    // decision space: we move to find localmax, so we go in the direction where arr[mid+1] or arr[mid-1] > arr[mid] 
    public int peakIndexInMountainArray(int[] arr) {
        return binarySearchLocalMax(arr, 0, arr.length-1);
    }

    int binarySearchLocalMax(int[] arr, int start, int end ){
        if(start > end){
            return -1;
        }

        int mid = start + (end-start)/2;

        // check if arr[mid] is localMax

        if(mid == arr.length-1 && arr[mid] > arr[mid]-1){ // mid is at the last index
            return mid;
        }

        if(mid == 0 && arr[mid] > arr[mid]+1){ // mid at the start
            return mid;
        }

        if(arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]){
            return mid;
        }

        // we keep searching in decision space
        if(arr[mid+1] > arr[mid]){
            // move right
            return binarySearchLocalMax(arr, mid+1, end);
        } else{
            //move left
            return binarySearchLocalMax(arr, start, mid-1);
        }

    }

}
