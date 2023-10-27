class Solution {
    public String longestPalindrome(String s) {
        // expand at each character and figure out if it's the longest
        // take one/two char at a time

        int n = s.length();
        String res = String.valueOf(s.charAt(0));
        for(int i=0; i < n-1; i++){
            String withOneChar = findPalindromicString(s, i, i, n);
            String withTwoChars = findPalindromicString(s, i, i+1, n);

            String bigger = withOneChar.length() > withTwoChars.length() ? withOneChar : withTwoChars;
            res = res.length() > bigger.length() ? res: bigger;
        } 
        return res;
    }

    String findPalindromicString(String s, int start, int end, int n){
        if(start != end && s.charAt(start) != s.charAt(end)){
            return "";
        }
        
        // need to expand string
        while(start > 0 && end < n-1 && s.charAt(start-1) == s.charAt(end+1)){
                // we can expand
                start--;
                end++;
        }

        return s.substring(start, end+1);
    }
}
