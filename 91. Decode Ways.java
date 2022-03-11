// number of ways: Sum the choices
// choices: We can take 1 character or 2 characters to encode at a time
// decodeWays(s, i+1, dp) + decodeWays(s, i+2, dp);

class Solution {
    int res=0;
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
       return decodeWays(s, 0, dp); 
    }
    
    private int decodeWays(String s, int i, int[] dp){
        // base condition
        
        if(i == s.length()){
            return 1;
        }
        
        if(s.charAt(i) == '0'){
            return 0;
        }
        
        if(i == s.length()-1){
            return 1;
        }
        
        if(dp[i] != -1){
            return dp[i];
        }
        
        // choice diagram
        if( Integer.parseInt(s.substring(i,i+2)) < 27 ){
            dp[i] = decodeWays(s, i+1, dp) + decodeWays(s, i+2, dp);
            res = dp[i];
        }else{
            dp[i] = decodeWays(s, i+1,dp);
            res = dp[i];
        }
            
        
        return res;
        
    }
}
