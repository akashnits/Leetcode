class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for(int num: nums){
            List<Integer> factors = findFactors(num);

            for(int factor: factors){
                sum += factor;
            }
        }
        return sum;
    }


    List<Integer> findFactors(int num){
        List<Integer> factors = new ArrayList();
        int factorsCount = 0;
        for(int i=1; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                // we have two factors i and n/i - handle perfect square case
                factors.add(i);
                if( i != num/i){
                    factors.add(num/i);
                    factorsCount += 2;
                }else{
                    factorsCount += 1;
                }
                

                if(factorsCount > 4){ // early exit
                    // invalid case
                    return new ArrayList(); // empty
                }
            }
        }

        return factorsCount < 4 ? new ArrayList(): factors;
    }
}
