class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        int len1 = sentence1.length();
        int len2 = sentence2.length();

        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");

        StringBuilder prefix = new StringBuilder();
        StringBuilder suffix = new StringBuilder();

        if(len1 < len2){
            return helper(words1, words2);
        }else if(len2 < len1){
            return helper(words2, words1);
        }else{
            return sentence1.equals(sentence2);
        }
    }


    boolean helper(String[] words1, String[] words2){
        int idx = 0;
            // loop over smaller string and process all it's words (add to prefix of suffix)
            int n = words1.length;
            int m = words2.length;
            int start = 0;
            int end = m-1;

            while(start < n && words1[start].equals(words2[idx])){
                // longest prefix
                start++;
                idx++;
            }

            if(start == n ){
                return true; // words1 is contained in longest prefix
            }

            // find the remaining in suffix ?
            int savedIdx = idx;
            idx = n-1;
            while(idx >= savedIdx && words1[idx].equals(words2[end])){
                // longest suffix
                end--;
                idx--;
            }
            if(idx < savedIdx){
                return true;
            }
            return false;
    }
}
