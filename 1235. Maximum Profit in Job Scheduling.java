class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        // each interval has startTime, endTime, profit
        int[][] interval = new int[n][3];
        for(int row=0; row < n; row++){
            interval[row][0] = startTime[row];
            interval[row][1] = endTime[row];
            interval[row][2] = profit[row];
        }

        Arrays.sort(interval, (a,b) -> a[0]-b[0]);
        Integer[] dp = new Integer[n];

        return calculateProfit(interval, n, 0, dp);
    }


    int calculateProfit(int[][] interval, int n, int idx, Integer[] dp){
        // base conditions

        // if we have reached the end of start/end time array
        if(idx == -1 || idx == n)
            return 0;

        if(dp[idx] != null){
            return dp[idx];
        }    
        

        // we may pick or may not
        // when we pick

        dp[idx] = Math.max(interval[idx][2] + 
                        calculateProfit(interval, n, findNextJobIndex(interval, idx+1, n-1, interval[idx][1]), dp),
                        calculateProfit(interval, n, idx+1, dp));
        return dp[idx];                
    }

    // find equals or next greater - interested in startTime only
    int findNextJobIndex(int[][] events, int l, int r, int target){
        int res = -1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(events[mid][0] >= target){
                // search in left half
                res = mid;
                r = mid-1;
            }else{
                // search in right half
                l = mid+1;
            }
        }
        return res;
    }
}
