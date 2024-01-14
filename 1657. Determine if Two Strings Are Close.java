class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()){
            return false;
        }

        // word1 and word2 should contain the same chars
        // and freq  should be same - we don't care about the char which has the freq as we can transform, so freq can be swapped
        int[] freqWord1 = new int[26];
        int[] freqWord2 = new int[26];

        for(char c: word1.toCharArray()){
            freqWord1[c-'a']++;
        }

        for(char c: word2.toCharArray()){
            freqWord2[c-'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((freqWord1[i] == 0 && freqWord2[i] != 0) || (freqWord1[i] != 0 && freqWord2[i] == 0)) {
                return false;
            }
        }

        Arrays.sort(freqWord1);
        Arrays.sort(freqWord2);

        for(int i=0; i < 26; i++){
            if(freqWord1[i] != freqWord2[i]){
                return false;
            }
        }
        return true;
    }
}
