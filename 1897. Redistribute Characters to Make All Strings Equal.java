class Solution {
    public boolean makeEqual(String[] words) {
        int n = words.length;
        if( n == 1) return true;

        // build freqency map
        Map<Character, Integer> freqMap= new HashMap();
        for(String word: words){
            for(char c: word.toCharArray()){
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            }
        }
        // check if freq of all chars equals n
        for(Map.Entry<Character, Integer> entry: freqMap.entrySet()){
            if(entry.getValue() % n != 0){
                return false;
            }
        }
        return true;
    }
}
