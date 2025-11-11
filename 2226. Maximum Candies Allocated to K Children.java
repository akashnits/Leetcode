class Solution {
    // Simplified: we need to bowl size ( max possible ) for which each children could get equal number of candies
    // Interesting constraint: We cannot merge the bowls but can split it. If we could merge it, we would have calculated the
    // total candies / children = max candies each child can have
    // Let's say we have red, green and yellow candy - ( have a lot of yellow candies - such that after the split of yellow pile
    // number of yellow candy in the pile exceed red/green -> we allocate yellow and red/green remains unused
    // e.g. [1, 1, 9] k= 3
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;
        int lo = 1, hi= 1;
        for(int i=-0 ; i < n; i++)
            hi = Math.max(hi, candies[i]);
        
        int res = 0;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(canDistribute(candies, k, mid)){
                res = mid; // candidate
                lo = mid+1;
            }else{
                hi = mid -1;
            }
        }
        return res;
    }

    boolean canDistribute(int[] candies, long k, int bowlSize){
        long calculateNoBowls = 0;

        for(int candy: candies){
            calculateNoBowls += candy/bowlSize;
        }

        return calculateNoBowls >= k; // we have enough for every children
    }
}
