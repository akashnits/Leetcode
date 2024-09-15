class Solution {
    // [6,8] [0,2] [3,5]
    // 8, 0, 4
    // n = 3, score = 4
    public int maxPossibleScore(int[] start, int d) {
        // select integers such that we get max of ( absolute diff min )
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        
        int n = start.length;
        for(int i=0; i < n; i++){
            minValue = Math.min(minValue, start[i]);
            maxValue = Math.max(maxValue, start[i]);
        }

        int lo = 0;
        int hi = Math.abs(maxValue - minValue) + d;

        int res = 0;
        Arrays.sort(start);
        // binary seach on ans
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(isValidAbsDiff(start, d, mid)){
                res = mid;
                // go right to find max
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return res;
    }


    boolean isValidAbsDiff(int[] start, int d, int absMinDiff){
        long prev = start[0];
        for (int i = 1; i < start.length; i++) {
        // Calculate the next position: it must be at least `mid` distance from `prev`, or at least the original position `start[i]`.
        long next = Math.max(prev + absMinDiff, (long) start[i]);

        // If `next` exceeds the maximum allowed position (`start[i] + d`), return false.
        if (next > start[i] + d) {
            return false;
        }

        // Update `prev` to be the current `next` position.
        prev = next;
    }

    // If the loop completes, it means all positions are valid, return true.
    return true;
    }


}
