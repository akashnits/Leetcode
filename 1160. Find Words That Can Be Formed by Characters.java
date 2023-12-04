class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> freqMap = new HashMap();

        for(char c: chars.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        int res =0;
        for(String word: words){
            // check if this word is good string and if yes add length to res
            Map<Character, Integer> map = new HashMap(freqMap);
            boolean goodString = true;
            for(char ch: word.toCharArray()){
                if(map.containsKey(ch)){
                    // reduce count if > 0
                    if(map.get(ch) > 0){
                        map.put(ch, map.get(ch)-1);
                    }else{
                        // bad string as no more char to use
                        goodString= false;
                        break;
                    }
                }else{
                    // bad string
                    goodString = false;
                    break;
                }
            }

            res = res + (goodString ? word.length(): 0);
        }

        return res;
    }
}
