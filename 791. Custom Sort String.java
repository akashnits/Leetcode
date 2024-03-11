class Solution {
    public String customSortString(String order, String s) {
        StringBuilder res = new StringBuilder();
        Map<Character, Integer> map = new HashMap();

        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char c: order.toCharArray()){
            while(map.containsKey(c) && map.get(c) > 0){
                res.append(c + "");
                map.put(c, map.getOrDefault(c, 0) - 1);
            }
            map.remove(c);
        }

        // loop over set and add to last
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            int freq = entry.getValue();
            char c = entry.getKey();
            while(freq-- > 0){
                res.append(c + "");
            }
        }

        return res.toString();
    }
}
