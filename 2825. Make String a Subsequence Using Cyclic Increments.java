class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        // str1 >= str2
        int len1 = str1.length();
        int len2 = str2.length();

        if(len1 < len2){
            return false; // str2 can't be subsequence
        }

        int idx1 = 0;
        int idx2 = 0;

        // loop over str1 and try matching with str2
        while(idx1 < len1 && idx2 < len2){
            char c1 = str1.charAt(idx1);
            char c2 = str2.charAt(idx2);

            // case 1: both chars match
            if(c1 == c2){
                idx1++;
                idx2++;
                continue;
            }

            // case 2: perform operation - add 1 to c1 
            char newC1 = (c1 == 'z') ? 'a' : (char) (c1 + 1); 

            // compare with c2
            if(newC1 == c2){
                idx2++;
            }

            idx1++; // done with c1
        }

        return idx2 >= len2;
    }
}
