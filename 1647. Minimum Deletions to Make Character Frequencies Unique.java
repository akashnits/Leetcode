class Solution {
    public int minDeletions(String s) {
        int res =0;
        // create a freq map
        Map<Character, Integer> map = new HashMap();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // create a set
        Set<Integer> set = new HashSet();
        
        // loop over map
        for(int value: map.values()){

            if(set.contains(value)){
                // we have used this freq already, find another freq maybe ?
                while(value > 0 && set.contains(value)){
                    res++;
                    value--;
                }
            }
            set.add(value);
        }
        return res;
    }
}
