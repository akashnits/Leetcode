class Solution {
    public String longestPrefix(String s) {
        
        
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
        
        return s.substring(0,j);
    }
}
