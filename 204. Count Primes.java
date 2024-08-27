class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        for(int i=2; i <= Math.sqrt(n); i++){
            for(int j =i; i * j < n; j++){
                int idx = i * j;
                if(isPrime[idx]){
                    isPrime[idx] = false;
                }
            }
        }

        int count  =0;
        for(int i=2; i < n; i++){
            count += isPrime[i] ? 1: 0;
        }
        return count;
    }
}
