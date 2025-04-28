class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int count = 0;
        for(int i=0; i < n-2; i++){
            for(int j=i+1; j< n-1; j++){
                //optimize: we only move frwd is |arr[i] - arr[j] <= a|
                if(Math.abs(arr[i] - arr[j]) > a){
                    continue;
                }
                for(int k=j+1; k < n; k++){
                    if(isGoodTriplet(arr, a, b, c, i, j, k)){
                        count++;
                    }
                }
            }
        }
        return count;
    }


    boolean isGoodTriplet(int[] arr, int a, int b, int c, int i, int j, int k){
        return (Math.abs(arr[i] - arr[j]) <= a) && (Math.abs(arr[j] - arr[k]) <= b) 
                && (Math.abs(arr[i] - arr[k]) <= c);
    }
}
