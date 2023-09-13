class Solution {
    public int maxValue(int[][] events, int k) {
        // sort the given array based on start time
        Arrays.sort(events, (a, b) -> a[0]-b[0]);
        int n = events.length;

        int[][] dp = new int[n][k+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return calculateEventsMaximizingValue(events, n, 0, k, dp);
    }


    int calculateEventsMaximizingValue(int[][] events, int n, int idx, int k, int[][] dp){
        // base condition
        if(idx == -1 || idx == n){
            return 0;
        }

        if(k == 0){
            // can't attend any more events
            return 0;
        }

        if(dp[idx][k] != -1){
            return dp[idx][k];
        }

        // choices we have - we can attend the event or we don't
        
        // attending the event
        int nextEventIdx = findNextEvent(events, idx+1, n-1, events[idx][1]);
        dp[idx][k]= Math.max(events[idx][2] + 
                                          calculateEventsMaximizingValue(events, n , nextEventIdx, k-1, dp),
                                          calculateEventsMaximizingValue(events, n, idx+1, k, dp));
        return dp[idx][k];
    }

    // must be just greater than target
    int findNextEvent(int[][] events, int l, int r, int target){
        int res = -1;
        while(l <= r){
            int mid = l+ (r-l)/2;
            if(events[mid][0] > target){
                // possible candidate
                res = mid;
                // go left
                r= mid-1;
            }else{
                // go right
                l= mid+1;
            }
        }
        return res;
    }


}
