class Solution {
    public int candy(int[] ratings) {
        // dp[i] candy for children at i
        int n = ratings.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for(int i=1; i < n; i++){
            if(ratings[i] > ratings[i-1]){
                dp[i] = dp[i-1]+1;
            }
        }
        
        for(int j= n-2; j >=0; j--){
            if(ratings[j] > ratings[j+1]){
                dp[j] = Math.max(dp[j], dp[j+1] +1);
            }
        }
        
        int ans=0;
        for(int count: dp){
            ans += count;
        }
        
        return ans;
    }
}
