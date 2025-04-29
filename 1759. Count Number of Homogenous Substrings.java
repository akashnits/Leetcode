class Solution {
    public int countHomogenous(String s) {
        int start = 0;
        int end = 0;
        int res = 0;

        int n = s.length();
        int MOD = 1000000007;

        while(end < n){
            char charAtEnd = s.charAt(end);
            char charAtStart = s.charAt(start);

            // shrink here - invalid window
            if(charAtEnd != charAtStart){                
                start = end;
            }else{
                // valid window of size (end-start+1)
                int len = end- start + 1;
                res = (res + len) % MOD;
                end++;
            }
        }
        return res;
    }
}
