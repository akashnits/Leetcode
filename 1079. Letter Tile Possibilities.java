public class Solution {
    int count = 0;
    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> map = new HashMap<>();
        for (char tile : tiles.toCharArray()) {
            map.put(tile, map.getOrDefault(tile, 0) + 1);
        }
        backtrack(map);
        return count;
    }

    private void backtrack(Map<Character, Integer> map) {
        
        for (char c : map.keySet()) {
            int freq = map.get(c);
            if(freq == 0){
                continue;
            }
            
            map.put(c, freq - 1);
            count++;
            backtrack(map);
            map.put(c, freq);
        }
    }
}
