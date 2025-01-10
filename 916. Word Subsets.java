class Solution {
    // Intuition - for any word to be universal in the array words1, it must include all the characters from all words in words2 array
    // i.e. if we keep track of chars appearing in words2 array, we could say if it's universal or not
    // store the max frequency of the char appearing across all words in words2 - maxFreqArr
    // for a word to be universal, the frequency of every char in universal word freq arr > frequency of every char store in maxFreqArr
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
        List<String> result = new ArrayList();
        for(String w1: words1){
            result.add(w1);
        }
        
        int[] maxFreq = new int[26];
        
       for(String w2: words2){
           int[] freq = new int[26];
           for(char c: w2.toCharArray()){
               freq[c-'a']++;
               maxFreq[c-'a'] = Math.max(maxFreq[c-'a'], freq[c-'a']);
           }
       }
    
        
        ListIterator<String> itr = result.listIterator();
        while(itr.hasNext()){
            String next = itr.next();
            if(!isSubset(next, maxFreq)){
                itr.remove();
            }
        }
        
        
        return result;
    }
    
    
    boolean isSubset(String a, int[] maxFreq){
        // check if b is subset of a i.e.  if every letter in b occurs in a including multiplicity.
        int[] freq = new int[26];
        
        for(char c1: a.toCharArray()){
            freq[c1-'a']++;
        }
        
        for(int i=0; i < 26; i++){
            if(freq[i] < maxFreq[i]){
                return false;
            }
        }
        return true;
    }
}
