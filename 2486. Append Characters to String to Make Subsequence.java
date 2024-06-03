class Solution {
    public int appendCharacters(String s, String t) {
        int m = s.length();
        int n = t.length();
        int j=0; 
        int i=0;
        while(i < m && j < n){
            if(s.charAt(i)==t.charAt(j)){
                j++; // we can use this char, so no need to append
            }  
            i++;  
        }
        return t.length()-j;
    }
}
