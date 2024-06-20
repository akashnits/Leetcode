class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        // tastiness range from 0 to maxAbsDiff
        int n = price.length;
        int min =0;
        int max = price[n-1] - price[0];
        // explore tastiness from min to max
        int res = -1;
        while(min <= max){
            int mid = min + (max- min)/2;
            if(checkIfValidMinTasteness(price, k, mid)){
                res = mid;
                min = mid+1;// go right to find max tastinness
            }else{
                max = mid-1;
            }
        }
        return res;
    }

    boolean checkIfValidMinTasteness(int[] price, int k, int minTasteness){
        // choose k candies such that Math.abs(a, b) - diff b/w any two candy is >= minTasteness
        int count = 1; // we always choose candy at index 0
        int prevTastiness = price[0];
        for(int i=1; i < price.length; i++){
            if(price[i] - prevTastiness >= minTasteness){
                // we choose this 
                prevTastiness = price[i];
                // check if count == k
                if(++count == k){
                    return true;
                }
            }
        }
        return false;
    }
}
