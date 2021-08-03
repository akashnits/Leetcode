class Solution {
  
  
    //Idea: Build dp table for LCS and iterate it started from end (n, m)
    // While iterating, if 
    // 1. chars are equal - append in result 
    // 2. chars are unequal - move in direction of max value of LCS and append the char from the string we selected ( direction we move )
    // At last, check for any chars which are left as we stopped looping if any of the strings length became '0'
    // append the remaining chars to result and return the reversed string.
  
  
    public String shortestCommonSupersequence(String str1, String str2) {
        
        int n = str1.length();
        int m = str2.length();
        
        int[][] dp = new int[n+1][m+1];
        
        //initialize dp array
        for(int i=0 ; i< n+1; i++){
            dp[i][0] = 0;
        }
        
        for(int j=0 ; j< m+1; j++){
            dp[0][j] = 0;
        }
        
        // fill up dp array with each cell containing LCS value
        for(int i =1; i < n+1; i++){
            for(int j= 1; j < m+1; j++){
                
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    //include in lcs
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        //build shortest common super sequence by iterating dp array from the end cell
        StringBuilder sb = new StringBuilder();
        
        int lenStr1= n;
        int lenStr2= m;
        
        while(lenStr1 > 0 && lenStr2 > 0){
            if(str1.charAt(lenStr1-1) == str2.charAt(lenStr2-1)){
                //this is common char from both strings, include this char
                sb.append(str1.charAt(lenStr1-1));
                lenStr1--;
                lenStr2--;
            }else{
                //since this char isn't equal, we move in the direction of 
                // maximum LCS so that we have more common chars ( to minimize 
                // supersequence length)
                // Also, appending the char from string which we selected (direction we move )
                if(dp[lenStr1-1][lenStr2] > dp[lenStr1][lenStr2-1]){
                    sb.append(str1.charAt(lenStr1-1));
                    lenStr1--;
                }else{
                    sb.append(str2.charAt(lenStr2-1));
                    lenStr2--;
                }
                
            }
        }
        
        // Now, we maybe some chars remaining from either str1 or str2
        // since our loop stopped at i or j reaching 0
        
        while(lenStr1 > 0){
            sb.append(str1.charAt(lenStr1-1));
            lenStr1--;
        }
        
        while(lenStr2 > 0){
            sb.append(str2.charAt(lenStr2-1));
            lenStr2--;
        }
        
        return sb.reverse().toString();
    }
}
