class Solution {
    int MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long res = 0;
        long evenCount = (n + 1) / 2; // how many even positions (5 choices)
        long oddCount = n / 2;        // how many odd positions (4 choices)

        long pow5 = binaryExponentition(5, evenCount);
        long pow4 = binaryExponentition(4, oddCount);

        res = (pow5 * pow4) % MOD;
        return (int) res;
    }

    private long simplePow(long base, long exp) {
        long result = 1;
        for (long i = 0; i < exp; i++) {
            result = (result * base) % MOD;
        }
        return result;
    }

    private long binaryExponentition(long base, long exp){
        // if exp is even, we can write (base ^ 2) ^ (exp / 2) i.e. (base ^ exp)
        // if exp is odd, we can write base * (base ^ exp-1) ; (exp-1) is even so we apply above

        if(exp == 0){
            return 1;
        } else if(exp % 2 == 0){
            // even
            return binaryExponentition((base*base) % MOD, exp/2);
        }else {
            // odd
            return (base * binaryExponentition(base, exp-1)) % MOD;
        }
    }
}
