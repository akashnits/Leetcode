class Solution {
    int minEatingSpeed = -1;
    // binary search on answer
    public int minEatingSpeed(int[] piles, int h) {
        // k range from 1 to max(piles)

        int n = piles.length;
        int maxEatingSpeed = 0;
        for(int i=0; i < n; i++) {
            maxEatingSpeed = Math.max(maxEatingSpeed, piles[i]);
        }
        findMinEatingSpeed(piles, 1, maxEatingSpeed, h);
        return minEatingSpeed;
    }

    void findMinEatingSpeed(int[] piles, int start, int end, int h){
        if(start > end){
            return;
        }

        int eatingSpeed = start + (end - start)/2;

        if(calculateEatingTime(piles, eatingSpeed) <= h){
            // koko can finish it under/on time
            minEatingSpeed = eatingSpeed;
            findMinEatingSpeed(piles, start, eatingSpeed-1, h);
        }else{
            // it couldn't, increase eating speed
            findMinEatingSpeed(piles, eatingSpeed+1, end, h);
        }

    }


    long calculateEatingTime(int[] piles, int eatingSpeed) {
        long time =0;
        for(int pile: piles){
            time += (int) Math.ceil( (double) pile/ eatingSpeed);
        }
        return time;
    }
}
