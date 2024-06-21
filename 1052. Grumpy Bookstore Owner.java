class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        // window size is minutes - fixed window size
        int start = 0;
        int end = 0;
        int n = customers.length;

        int[] left = new int[n];
        int[] right = new int[n];

        for(int i=0; i < n; i++){
            if(grumpy[i] == 0){
                // include this
                left[i] = (i > 0 ? left[i-1] + customers[i]: customers[i]);
            }else{
                left[i]  = (i > 0 ? left[i-1] : 0 );
            }
            int j = n-1-i;
            if(grumpy[j] == 0){
                // include this
                right[j] = (j < n-1 ? right[j+1] + customers[j] : customers[j]);
            }else{
                right[j] = ( j < n-1 ? right[j+1] : 0);
            }
        }

        int res = Integer.MIN_VALUE;
        int windowSum = 0;
        while(end < n){
            // expand here
            windowSum += customers[end];

            //check is window size == minutes - calculate res and find max
            if(end-start+1 == minutes){
                // total sum is leftSum + rightSum + windowSum
                int leftSum = start > 0 ? left[start-1] : 0;
                int rightSum = end < n-1 ? right[end+1] : 0;
                int totalSum = windowSum + leftSum + rightSum;

                res = Math.max(res, totalSum);
                // shrink here by one
                windowSum -= customers[start++];
            }
            end++;
        }
        return res;
    }
}
