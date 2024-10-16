class Solution {
    public String longestDiverseString(int a, int b, int c) {
        // maintain a maxHeap based on character freq
        PriorityQueue<CharWithFreq> maxHeap = new PriorityQueue<CharWithFreq>((x, y) -> (y.count - x.count));

        StringBuilder res = new StringBuilder();
        int[] conctvCharCount = new int[3]; // keeps track of consecutive count of a, b, c 

        // initlaize pq
        if(a > 0){
            maxHeap.offer(new CharWithFreq('a', a));
        }
        if(b > 0){
            maxHeap.offer(new CharWithFreq('b', b));
        }
        if(c > 0){
            maxHeap.offer(new CharWithFreq('c', c));
        }

        while(!maxHeap.isEmpty()){
            CharWithFreq polled = maxHeap.poll();
            // we can append it to the stringBuilder if conctvCharCount[c - 'a'] < 2
            if(conctvCharCount[polled.c - 'a'] < 2){
                appendAndUpdate(res, conctvCharCount, polled, maxHeap);
            }else{
                // we need another char whose freq is lesser
                if(!maxHeap.isEmpty()){
                    CharWithFreq secondMostFreqPolled = maxHeap.poll();
                    appendAndUpdate(res, conctvCharCount, secondMostFreqPolled, maxHeap);
                }else{
                    // we are done here
                    break;
                }
                maxHeap.offer(polled); // putting the most freq back as we couldn;t use it
            }
        }
        return res.toString();
    }


    private void appendAndUpdate(StringBuilder res, int[] conctvCharCount, 
                            CharWithFreq polled, PriorityQueue<CharWithFreq> maxHeap){
        res.append(polled.c);
        int newFreq = conctvCharCount[polled.c - 'a'] + 1;
        Arrays.fill(conctvCharCount, 0);
        conctvCharCount[polled.c - 'a'] = newFreq;
        // put it back
        if(polled.count > 1){
            maxHeap.offer(new CharWithFreq(polled.c , polled.count -1));
        }
    }


    class CharWithFreq{
        char c;
        int count;

        CharWithFreq(char c, int count){
            this.c = c;
            this.count = count;
        }
    }
}
