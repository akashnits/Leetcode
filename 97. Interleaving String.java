class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int o = s3.length();

        if(m + n != o){
            return false;
        }

        Boolean[][] dp = new Boolean[m+1][n+1];

        return solve(s1, s2, s3, 0, 0, dp);

    }


    boolean solve(String s1, String s2, String target, int i, int j, Boolean[][] dp){

        // base condition
        if(i == s1.length() && j == s2.length()){
            dp[i][j] = true;
            return true;
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }

        int k = i+j;

        // choices 
        char targetChar = target.charAt(k);

        if(i < s1.length() && targetChar == s1.charAt(i) && j < s2.length() && targetChar == s2.charAt(j)){
            // target char matches with both the chars - s1, s2
            // we may take either of them

                dp[i][j] =  solve( s1,  s2,  target,  i+1,  j, dp) || solve( s1,  s2,  target,  i,  j+1, dp);
                return dp[i][j];
        }else if(i < s1.length() && targetChar == s1.charAt(i)){
            // take from s1
                dp[i][j] =  solve( s1,  s2,  target,  i+1,  j, dp);
                return dp[i][j];
        }else if(j < s2.length() && targetChar == s2.charAt(j)){
            // take from s2
            dp[i][j]= solve( s1,  s2,  target,  i,  j+1, dp);
            return dp[i][j];
        } else{
            dp[i][j]= false;
            return dp[i][j];
        }
    }
}
