class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0;
        // no of rounds we can run within given time
        int noOfRounds = minutesToTest / minutesToDie;
        // max length of square matrix given pigs can solve
        int matrixLength = noOfRounds + 1;
        while (Math.pow(matrixLength, pigs) < buckets) {
            pigs += 1;
        }
        return pigs;
    }
}
