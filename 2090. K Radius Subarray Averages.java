class Solution {
    public int[] getAverages(int[] nums, int k) {
        // sliding window algo
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        // corner cases
        if( k == 0 ){
            return nums;
        }

        long windowLen = 2*k + 1; // min length to have non - negative average

        if(n < windowLen){
            return res;
        }

        int start = 0;
        int end = start;
        int mid = k;
        long windowSum = 0;
        int windowAvg = -1;

        while(end < n){

            windowSum += nums[end];
            if(end - start  == windowLen-1){
                // we have the window size now, calculate avg and place it
                windowAvg = (int) (windowSum / windowLen);
                res[mid] = windowAvg;
                mid++;
                // slide window
                windowSum -= nums[start];
                start++;
            }

            end++; // expand here
        }
        return res;
    }
}
