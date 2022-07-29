class Solution {
    
    Map<Character, Character> map1= new HashMap();
    Map<Character, Character> map2 = new HashMap();
    
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList();
        
        for(String word: words){
            if(doesMatch(word, pattern)){
                res.add(word);
            }
        }
        return res;
    }
    
    boolean doesMatch(String word, String pattern){
        map1.clear();
        map2.clear();
        
        for(int i=0; i < word.length(); i++){
            char c1 = word.charAt(i);
            char c2= pattern.charAt(i);
            
            if((map1.containsKey(c1) && map1.get(c1) != c2) || (map2.containsKey(c2) && map2.get(c2) != c1) ){
                return false;
            }
            
            map1.put(c1, c2);
            map2.put(c2, c1);
        }
        return true;  
    }
}
