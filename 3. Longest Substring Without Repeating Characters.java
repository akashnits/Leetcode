class Solution {
    public int lengthOfLongestSubstring(String s) {
        int lo=0, hi=0;
        
        int n = s.length();
        Set<Character> windowSet = new HashSet();
        int maxLength =0;
        int repeat = 0;
        while(hi < n){
            // expand here
            char charAtHi = s.charAt(hi);
            
            if(windowSet.contains(charAtHi)){
                repeat++;
            }else{
                windowSet.add(charAtHi);
            }
            
           // shrink here
            while(repeat == 1 && lo <= hi){ // make this window undesired
                char charAtLo = s.charAt(lo);
                if(charAtLo == charAtHi){
                    --repeat;
                }else{
                    windowSet.remove(charAtLo);
                }
                lo++;
            }

            maxLength = Math.max(maxLength, hi-lo+1);
            hi++;
        }
        return maxLength;
    }
}
