class Solution {
    public String clearStars(String s) {
        PriorityQueue<CharWithIndex> minHeap = new PriorityQueue<CharWithIndex>((a, b) -> (
            (a.c == b.c) ? (b.idx - a.idx) : (a.c - b.c)));

        StringBuilder sb = new StringBuilder(s);
        
        CharWithIndex minCharWithIndex = null;
        for(int i=0; i < s.length(); i++){
            char c = sb.charAt(i);
            if( c == '*'){
                // replace minCharWithIndex with #
                // get minCharWithIndex from minHeap
                if(minHeap.isEmpty()) continue; // can't do shit
                minCharWithIndex = minHeap.poll();
                sb.setCharAt(minCharWithIndex.idx, '#');
            }else{
                minHeap.offer(new CharWithIndex(c, i));
            }
        }

        StringBuilder res = new StringBuilder();
        // another loop to remove all * and #
        for(char cb: sb.toString().toCharArray()){
            if(cb == '*' || cb == '#'){
                continue;
            }
            res.append(cb);
        }
        return res.toString();
    }


    class CharWithIndex{
        char c;
        int idx;

        CharWithIndex(char c, int idx){
            this.c = c;
            this.idx = idx;
        }
    }
}
