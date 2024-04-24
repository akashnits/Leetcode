class Solution {
    public int longestStrChain(String[] words) {
        // group words as per size
        List<List<String>> groupList = new ArrayList<>();
        int maxLen = 0;
        for(String word: words){
            maxLen = Math.max(maxLen, word.length());
        }

        for(int i=0; i <= maxLen; i++){
            groupList.add(i, new ArrayList<String>());
        }

        for(String word: words){
            int wordLen = word.length();
            // get the list from wordLen and add the word to the list
            groupList.get(wordLen).add(word);
        }
        // start from the last level of the list
        int res = 0;
        for(int len = maxLen; len > 0; len--){
            for(String word: groupList.get(len)){
                res = Math.max(res, 1+findLongestChain(groupList, word, new HashMap<String, Integer>()));
            }
        }
        return res;
    }

    int findLongestChain(List<List<String>> wordList, String word1, Map<String, Integer> dp){
        int n = word1.length();
        // base condition
        if( n < 1){
            return 0;
        }

        if(dp.containsKey(word1)){
            return dp.get(word1);
        }

        int maxCount =0;
        // choices we have
        // for each word, find the longest chain and maximize it
        // go to one level down and check if any word is oneApart
        for(String word2: wordList.get(n-1)){
            if(isOneCharApart(word1, word2)){
                maxCount = Math.max(maxCount, 1 + findLongestChain(wordList, word2, dp));
                dp.put(word1, maxCount);
            }
        }
        return maxCount;
    }


    boolean isOneCharApart(String s1, String s2){
        if(s1.length() - s2.length() > 1){
            return false;
        }
        // use two pointers
        int i =0, j =0;
        boolean canAdjust = true;
        while(i < s1.length() && j < s2.length()){
            if(s1.charAt(i) != s2.charAt(j)){
                if(canAdjust){
                    i++;
                    canAdjust= false;
                }else{
                    return false;
                }
            }else{
                i++;
                j++;
            }
        }
        return true;
    }
}
