class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        int len = words.length;

        for(int i=0; i < len; i++){
            String word = words[i];
            int n = word.length();
            int m = searchWord.length();

            int w = 0, s = 0;
            while(w < n && s < m &&  word.charAt(w) == searchWord.charAt(s)){
                w++;
                s++;
            }

            // check if we reached end of the searchWord
            if(s == m){
                return i+1;
            }
        }
        return -1;
    }
}
