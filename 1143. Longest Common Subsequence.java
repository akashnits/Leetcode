class Solution {
    //idea: We compare the last character of both strings
    // if equal, we include it in lcs by increasing count and reducing input
    // if not, we try out two choices
    // 1. we make text1 smaller; 2. we make text2 smaller
    // and find the max length of two
    
    public int longestCommonSubsequence(String text1, String text2) {
        
        int row = text1.length();
        int col = text2.length();
        
        char[] text1Arr = text1.toCharArray();
        char[] text2Arr = text2.toCharArray();
        
        int[][] dp = new int[row+1][col+1];
        
        //initialize dp array, length of lcs is 0 if any of the strings
        // is empty
        for(int i=0; i< row+1; i++){
            dp[i][0] = 0;
        }
        for(int j=0; j< col+1; j++){
            dp[0][j] = 0;
        }
        
        for(int i = 1; i < row+1; i++){
            for(int j = 1; j < col+1; j++){
                
                if(text1Arr[i-1] == text2Arr[j-1]){
                    //this can be part of lcs as character is equal
                    dp[i][j]= 1 + dp[i-1][j-1];
                }else{
                    //we take maximum of tow choices
                    // we make text1 smaller and keep text2 same
                    // OR we make text2 smaller and keep text1 same
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[row][col];
    }
}