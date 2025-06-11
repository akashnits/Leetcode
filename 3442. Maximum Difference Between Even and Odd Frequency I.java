class Solution {
    public int maxDifference(String s) {
        Map<Character, Integer> map = new HashMap();

        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int minFreqEven = s.length()+1;
        int maxFreqOdd = 0;

        for(int freq: map.values()){
            if(freq % 2 == 0){
                // even
                minFreqEven = Math.min(minFreqEven, freq);
            }else{
                // odd
                maxFreqOdd = Math.max(maxFreqOdd, freq);
            }
        }
        return maxFreqOdd - minFreqEven;
    }
}
