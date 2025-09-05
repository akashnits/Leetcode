class Solution {
    // Apporach: re-write the equation: num1 - k * num2 = summation of k powers of 2
    // we need to figure out minimum k satisfying the equation
    // min value of k = number of set bits in the num1
    // max value of k = the number itself i.e. we use 2^0 which is 1

    // k >= bit count and k <= num1-k * num2
    // loop over [1, 60] and check for satisfibilty  
    public int makeTheIntegerZero(int num1, int num2) {
        for(int k = 1; k <= 60; k++){
            long result = (long) num1 - (long) k * num2;
            if(result < 0){
                break;
            } 
            int count = Long.bitCount(result);
            if(count <= k && k <= result){
                return k;
            }
        }
        return -1;
    }
}
