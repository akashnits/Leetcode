// Solution is variation of Longest Common Subsequence 
// Longest Common substring/ Longest common subarray length

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int max = 0;
        int m = nums1.length;
        int n= nums2.length;
        int[][] dp = new int[m+1][n+1];
        
        for(int i=0; i< m; i++){
           dp[i][0] = 0; 
        }
        for(int j=0; j< n; j++){
            dp[0][j] = 0;
        }
        
        for(int i=1; i< m+1; i++){
            for(int j=1; j < n+1; j++){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    max = Math.max(dp[i][j], max);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }
}
