class Solution {
    public int minimumPushes(String word) {
        // calculate number of distinct chars
        char[] charArr = word.toCharArray();
        
        Map<Character, Integer> map = new HashMap();
        for(char c: charArr){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // most frequent element is at keypad position 1 and so on...
        // sort the chars as per frequency
        List<Character> charList = new ArrayList();
        charList.addAll(map.keySet());

        Collections.sort(charList, (a, b) -> (map.get(b) - map.get(a)));
        int n = charList.size();

        int res = 0;
        // charList is sorted as per frequency
        for(int k=0; k < n; k++){
            char c = charList.get(k);
            // k == 0 means most frequent
            if(k < 8){
                // we put it first position in keypad
                res += map.get(c) * 1; // cost is 1
            }else if( k < 16){
                // we put it at second position in keypad
                res += map.get(c) * 2;
            }else if( k < 24 ){
                // we put it at second position in keypad
                res += map.get(c) * 3;
            }else{
                // we put it at last position
                res += map.get(c) * 4;
            }
        }
        return res;
}
}
