class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // use bucket sort - index i stores freq of element i+1
        int[] buckets = new int[1001];

        // loop over arr1 and store freq
        for(int i=0; i < arr1.length; i++){
            int idx = arr1[i];
            buckets[idx] += 1;
        }

        int[] res = new int[arr1.length];
        int j = 0;
        // loop over arr2 and find relative ordering
        for(int ele: arr2){
            // find frequency of this element
            while(buckets[ele]-- > 0){
                res[j++] = ele;
            }
        }

        // loop over buckets and find non-zero value
        for(int k=0; k < 1001; k++){
            while(buckets[k]-- > 0){
                res[j++] = k;
            }
        }

        return res;
    }
}
