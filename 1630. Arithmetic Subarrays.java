class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = l.length;
        List<Boolean> res = new ArrayList();
        for(int i=0; i < n; i++){
            int size = r[i] - l[i]+1;
            int[] arr = new int[size];
            int k=0;
            // create array based on range
            for(int j=l[i]; j <= r[i]; j++){
                arr[k++] = nums[j];
            }
            boolean flag = isSeqArithmetic(arr);
            res.add(flag);
        }
        return res;
    }

    boolean isSeqArithmetic(int[] arr){
        Arrays.sort(arr);
        int d = arr[1]-arr[0];
        for(int i=1; i < arr.length-1; i++){
            if(arr[i+1]- arr[i] != d){
                return false;
            }
        }
        return true;
    }
}
