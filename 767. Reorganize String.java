class Solution {
    // approach: using a pq 
    // contraint: freq > 0 and can't pick last picked one
    public String reorganizeString(String s) {
        PriorityQueue<CharWithFreq> maxHeap = new PriorityQueue<CharWithFreq>((a, b) -> b.freq - a.freq);
        
        Map<Character, Integer> freqMap = new HashMap();

        // build pq
        for(char c: s.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c, 0) +1);
        }

        for(Map.Entry<Character, Integer> entry: freqMap.entrySet()){
            char key = entry.getKey();
            int value = entry.getValue();

            maxHeap.offer(new CharWithFreq(key, value));
        }

        StringBuilder res = new StringBuilder();
        Character lastUsedChar = null;
        for(int i=0; i < s.length(); i++){
            // fill each position with a char from pq
            if(maxHeap.isEmpty()) return "";

            // we try using the char with highest freq unless it's not picked up in the prev step
            
            // check if top element is lastUsedChar
            if(lastUsedChar != null && maxHeap.peek().c == lastUsedChar){
                // we use the second last element if there is
                if(maxHeap.size() > 1){
                    CharWithFreq temp = maxHeap.poll();
                    CharWithFreq actual = maxHeap.poll();
                    res.append(new Character(actual.c));
                    lastUsedChar= actual.c;
                    if(--actual.freq > 0){
                        maxHeap.offer(actual);
                    }
                    maxHeap.offer(temp);
                }else{
                    return "";
                }
            }else{
                // can use top element
                CharWithFreq polled = maxHeap.poll();
                res.append(new Character(polled.c));
                lastUsedChar= polled.c;
                if(--polled.freq > 0){
                    maxHeap.offer(polled);
                }
            }
        }

        return res.toString();
    }

    class CharWithFreq{
        char c;
        int freq;

        CharWithFreq(char c, int freq){
            this.c = c;
            this.freq= freq;
        }
    }
}
