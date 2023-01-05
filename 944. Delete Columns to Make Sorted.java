class Solution {
    public int minDeletionSize(String[] strs) {
        int deletion = 0;
        if(strs.length == 0){
            return deletion;
        }

        int n = strs[0].length();
        for(int i=0; i < n; i++){
            char prevChar = ' ';
            // compare ith letter of all words
            for(String word : strs){
                char c = word.charAt(i);
                if(prevChar != ' ' && prevChar - c > 0){
                    deletion += 1;
                    break;
                }
                prevChar = c;
            }
        }
        return deletion;
    }
}
