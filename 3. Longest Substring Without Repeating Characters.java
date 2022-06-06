class Solution {
    public int lengthOfLongestSubstring(String s) {
        int lo=0, hi=0;
        
        int n = s.length();
        Set<Character> windowSet = new HashSet();
        int maxLength =0;
        int duplicate = 0;
        while(hi < n){
            // expand here
            char c = s.charAt(hi);
            
            if(windowSet.contains(c)){
                duplicate = 1;
                // we need shrink until we drop c from left
                while( lo<=hi && duplicate == 1){
                    if(s.charAt(lo) == c){
                        // we drop it
                        duplicate=0;
                    }
                    windowSet.remove(s.charAt(lo));
                    lo++;
                }
            }
            windowSet.add(c); // adds to set if not already present
            maxLength = Math.max(maxLength, hi-lo+1);

            hi++;
        }
        return maxLength;
    }
}
