class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        // number cannot start with 0
        // process the number with all digits at once
        int m = abbr.length();
        int n = word.length();

        // i for abbr, j for word
        int i = 0, j = 0;
        while(i < m && j < n){
            char abbrC = abbr.charAt(i);

            // if abbrC is zero, illegal
            if(abbrC == '0'){
                return false;
            }else if(isAlphabet(abbrC)){// abbrC is alphabet
                char wordC = word.charAt(j);
                if(abbrC != wordC){
                    return false;
                }else{
                    // move frwd
                    i++; 
                    j++;
                }
            }else{
                // abbrC is digit and not equals 0
                // construct the digit first
                int k = i;
                while(k < m && !isAlphabet(abbr.charAt(k))){
                    k++;
                }

                // convert into int
                int len = Integer.parseInt(abbr.substring(i, k));
                // move i to k
                i = k;
                // move j point by length len
                j += len;
            }
        }

        return i ==m && j == n;
    }

    boolean isAlphabet(char c){
        int val = (int) (c - 'a');
        return val >= 0 && val < 26;
    }
}
