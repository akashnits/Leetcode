class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()){
            return -1;
        }
        int[] lps = createLPS(needle);
        return findPattern(lps, haystack, needle);
    }
    
    public int findPattern(int[] lps, String text, String pattern){

 		// traverse lps array
 		int j=0;
 		int i=0;

 		while( i < text.length() && j < pattern.length()){
 			if(text.charAt(i) == pattern.charAt(j)){
 				i++;
 				j++;
 			}else{
 				if(j != 0){
 					j = lps[j-1];
 				}else{
 					i++;
 				}
 			}
            if(j == pattern.length()){
                return i-j;
            }
 		}

 		return -1;
 	}


 	public int[] createLPS(String s) {
          int j=0;
          int i= 1;

          int[] lps = new int[s.length()];
          lps[0] =0;

          while(i < s.length()){
              if(s.charAt(i) == s.charAt(j)){
                  lps[i] = j+1;
                  i++;
                  j++;
              }else{
                  //check if j is at 0
                  if(j != 0){
                      j = lps[j-1];
                  }else{
                      lps[i] =0;
                      i++;
                  }
              }
          }

          return lps;
      }
}
