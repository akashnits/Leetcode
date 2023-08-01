class Solution {
    public int longestSubstring(String s, int k) {
        int res =0;
        int n = s.length();

        Set<Character> set = new HashSet();
        for(char c: s.toCharArray()){
            set.add(c);
        }

        int uniqueCharCount  = set.size();

        for(int permissibleCharCount = 1; permissibleCharCount <= uniqueCharCount; permissibleCharCount++){

            int start =0; 
            int end =0;
            
            int count =0; // keeps count of elements in the window whose freq is equals/greater that k

            Map<Character, Integer> windowsMap = new HashMap();
            while(end < n){
                // include this char in the window
                char c = s.charAt(end);
                windowsMap.put(c, windowsMap.getOrDefault(c, 0) + 1);
                // check if freq == k
                if(windowsMap.get(c) == k){
                    // we have this char satisfying the condition - freq is equals/greater that k
                    count++;
                }

            

                // check for window validity - variable size window , shrink it until it becomes valid again
                while(start <= end && windowsMap.size() > permissibleCharCount ){ // have more chars in the window than allowed

                    // shrink here - try making it valid
                    // remove this char from the window
                    char c1 = s.charAt(start);
                    if(windowsMap.containsKey(c1)){
                        windowsMap.put(c1, windowsMap.get(c1) - 1);
                        // check if freq reduced to k-1
                        if(windowsMap.get(c1) == k-1){
                            // we have this char having freq less than k
                            count--;
                        }

                        if(windowsMap.get(c1) == 0){
                            // remove from the windowsMap
                            windowsMap.remove(c1);
                        }
                    }
                    start++;
                }

                if(count == windowsMap.size()){
                    res = Math.max(res, end-start+1); // valid window, hence calculated length and maximize
                }
                end++;
            }
        }



        return res;
    }
}
