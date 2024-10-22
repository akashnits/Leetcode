class Solution {
    public int maxUniqueSplit(String s) {
       return splitInUniqueWords(s, s.length(), 0, "", new HashSet());
    }

    int splitInUniqueWords(String s, int n, int idx, String currWord, Set<String> uniqueWords){
        if(idx == n){
            return 0;
        }

        currWord += String.valueOf(s.charAt(idx));

        // check if it's not in set
        if(!uniqueWords.contains(currWord)){
            // we can either put this in set and reurse
            uniqueWords.add(currWord);
            int place = 1 + splitInUniqueWords(s, n, idx+1, "", uniqueWords);
            // don't put it in the set
            uniqueWords.remove(currWord);
            int skip = splitInUniqueWords(s, n, idx+1, currWord, uniqueWords);
            return Math.max(place, skip);
        }else{
            // we must not add this to set
            return splitInUniqueWords(s, n, idx+1, currWord, uniqueWords);
        }
    }
}
