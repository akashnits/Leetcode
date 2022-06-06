class Solution {
    public String frequencySort(String s) {
        // create a freq hashMap
        int n = s.length();
    
        Map<Character, Integer> freqMap = new HashMap();
        for(char c: s.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c,0)+1);
        }
        
        // create a maxHeap 
        PriorityQueue<Character> pq = new PriorityQueue<Character>(
        (a, b) -> freqMap.get(b) - freqMap.get(a));
        
        for(char key: freqMap.keySet()){
            pq.offer(key);
        }
        
        StringBuilder result = new StringBuilder();
        
        while(!pq.isEmpty()){
            char c = (char) pq.poll();
            int k = freqMap.get(c);
            String str= Character.toString(c);
            while(k-- > 0){
                // append to stringbuilder
                result.append(str);
            }
        }
        
        return result.toString();
    }
}
