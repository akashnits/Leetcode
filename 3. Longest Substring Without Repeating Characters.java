class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        
        int maxLength =0;
        int windowLength =0;
        int i=0, j=0;
        boolean duplicateExist= false;
        
        Set<Character> set = new HashSet<Character>();
        
        while( j < n ){
            
            char c = s.charAt(j);
            // include char 
            if(set.contains(c)){
                // duplicate found
                duplicateExist= true;
            }else{
                set.add(c);
            }
            
            
            windowLength = j-i+1;
            
            if(!duplicateExist){
                // possible candidate
                maxLength = Math.max(maxLength, windowLength);
            }
            
            // shrink until no duplicate exists
            while(duplicateExist){
                char ch = s.charAt(i);
                if(ch == c){
                    // we are dropping duplicate
                    duplicateExist = false;
                }else{
                    set.remove(ch);
                }
                i++;
            }
            j++;
        }
        return maxLength;
    }
}
