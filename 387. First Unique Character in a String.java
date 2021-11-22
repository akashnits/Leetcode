class Solution {
    public int firstUniqChar(String s) {
        
        Map<Character, Integer> map = new HashMap();
        
        char[] charArray = s.toCharArray();
        for(char c : charArray){
            map.put(c, 1 + map.getOrDefault(c, 0));
        }
        
        for(int i=0; i< s.length(); i++){
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}
