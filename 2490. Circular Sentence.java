class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        for(int i=0; i < words.length-1; i++){
            String currWord = words[i];
            String nextWord = words[i+1];

            if(currWord.charAt(currWord.length() -1) != nextWord.charAt(0)){
                return false;
            }
        }

        return words[0].charAt(0) == words[words.length-1].charAt(words[words.length-1].length() -1);
    }
}
