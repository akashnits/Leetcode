class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int n = s.length();
        // start with string of length n ... 2

        for(int len=n; len > 1; len--){
            int numOfSubstr = n-len+1;
            int start =0;
            int end = start+len-1;
            while(numOfSubstr-- > 0){
                if(s.charAt(start) == s.charAt(end)){
                    return len-2;
                }
                start++;
                end++;
            }
        }
        return -1;
    }
}
