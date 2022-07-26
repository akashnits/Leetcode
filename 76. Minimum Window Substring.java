class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        String result = "";
        int i=0, j=0;
        
        
        
        Map<Character, Integer> freqMap = new HashMap();
        for(char c: t.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c, 0) +1);
        }
        int charsToFind = freqMap.size();
        int windowLength =0;
        int minWindowLength = s.length()+1;
        
        while( j < n ){
            
            // include char at j
            char charAtHi = s.charAt(j);
            // check if char is of interest
            if(freqMap.containsKey(charAtHi)){
                // we have found a char, decrement freq
                freqMap.put(charAtHi, freqMap.get(charAtHi)-1);
                if(freqMap.get(charAtHi) == 0){
                    // we have one less chars to find
                    charsToFind--;
                }
            }
            
            
            
            // shrink here until we drop a char we wanted i.e. charsToFind becomes 1
            while(charsToFind == 0){
                // check if possible candidate 
                windowLength = j-i+1;
                if(windowLength < minWindowLength){
                    result = s.substring(i, i+ windowLength);
                    minWindowLength = windowLength;
                }
                char charAtLo = s.charAt(i);
                // check if char is of interest
                if(freqMap.containsKey(charAtLo)){
                    freqMap.put(charAtLo, freqMap.get(charAtLo)+1);
                    if(freqMap.get(charAtLo) == 1){
                        // we dropped a char we needed
                    charsToFind++;
                    }
                }
                i++;
            }
            j++;
        }
        
        return minWindowLength == s.length()+1 ? "": result;
    }
}
