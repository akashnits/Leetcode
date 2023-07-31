class Solution {
    public String minWindow(String s, String t) {

        String res = "";
        int minLength = s.length();
        // corner case
        if(t.length() > s.length()){
            return res;
        }

        Map<Character, Integer> windowsMap = new HashMap();
        for(char c: t.toCharArray()){
            windowsMap.put(c, windowsMap.getOrDefault(c, 0)+1);
        }

        int distChars = windowsMap.size(); // distChars count to be found
        
        int start =0, end =0;

        int n = s.length();
        
        // variable size sliding window algorithm

        while(end < n){
            char chAtEnd = s.charAt(end);
            // check if char is contained in the map
            if( windowsMap.containsKey(chAtEnd) ){
                int freq = windowsMap.get(chAtEnd) -1;
                windowsMap.put(chAtEnd, freq);
                if(freq == 0){
                    // we have found this char, reduce distChars count to be found
                    distChars--;
                }
            }

            // check for window validity
            while(start <= end && distChars == 0){
                // calculate length
                int length = end - start +1;
                if(length <= minLength){
                    res = s.substring(start, end+1);
                    minLength = length;
                }

                char chAtStart = s.charAt(start);
                if(windowsMap.containsKey(chAtStart)){
                    int freq = windowsMap.get(chAtStart) +1;
                    windowsMap.put(chAtStart, freq);
                    if(freq > 0){
                        // we have dropped a required char, made window invalid
                        distChars++;
                    }
                }

                // shrink here
                start++;
            }

            // expand here
            end++;
        }

        return res;
    }
}
