class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if( n == 1 ) return 1;
        Arrays.sort(envelopes, (a, b) -> (a[0] == b[0] ? b[1]-a[1] :a[0]-b[0]));

        // dp[i] represents the length of longest subsequence at i
        int[] dp = new int[n];
        // each envelope size is 1
        Arrays.fill(dp, 1);
        int res =0;

        // Approach #1 - Times out O(n^2)
        for(int i=1; i < n; i++){
            for(int j=0; j < i; j++){
                // we loop through 0 to i-1 for each i in 1.. n-1
                // condition of increasing subsequence, width and height of ith envelope > jth envelope
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            // we want max of dp[i]
            res = Math.max(res, dp[i]);
        }

        // Approach #2 - based on binary seach O(nlogn)
        // find LIS based on height envelope[i][1]
        for(int[] envelope : envelopes){
        int index = Arrays.binarySearch(dp, 0, res, envelope[1]);
        if(index < 0){
            index = -(index + 1);
        }
        dp[index] = envelope[1];
        if(index == res)
            res++;
        }
        return res;
    }
}
