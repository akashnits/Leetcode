class Solution {
    public int longestPalindrome(String s) {
        int[] freqLowerCase= new int[26];
        int[] freqUpperCase = new int[26];

        for(char c: s.toCharArray()){
            if(Character.isLowerCase(c)){
                freqLowerCase[c-'a']++;
            }else{
                freqUpperCase[c-'A']++;
            }
        }

        // we may include a single char if available - look for odd value
        boolean isSingleCharAvailable = false;
        // count pairs of same char
        int pairs =0;
        for(int freq1: freqLowerCase){
            if(freq1 % 2 == 1) isSingleCharAvailable= true;
            pairs += freq1 / 2;
        }

        for(int freq2: freqUpperCase){
            if(freq2 % 2 == 1) isSingleCharAvailable= true;
            pairs += freq2 / 2;
        }

        return isSingleCharAvailable ? (pairs * 2 +1): (pairs * 2);
    }
}
