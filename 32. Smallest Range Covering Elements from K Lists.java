class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {

        int k = nums.size();

        // create a minHeap 
        PriorityQueue<Truple> minHeap = new PriorityQueue<Truple>((truple1, truple2) -> (truple1.val - truple2.val));

        // create a range
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for(int i=0; i < k; i++){
            // get the first element and add to minHeap
            List<Integer> list = nums.get(i);
            int val = list.get(0);
            minHeap.offer(new Truple(val, i, 0)); // row - i, col - 0
            max = Math.max(max, val);
        }

        int range = Integer.MAX_VALUE;
		int start = -1, end = -1;

        while(minHeap.size() == k){
            Truple curr = minHeap.poll();
            int row = curr.row;
            int col = curr.col;

            if( max - curr.val < range ){
                start = curr.val;
                end = max;
                range = end - start;
            }

            if( col < nums.get(row).size() -1){
                // add next element 
                curr = new Truple(nums.get(row).get(col+1), row, col+1);
                minHeap.offer(curr);
                if(curr.val > max ){
                    max = curr.val;
                }
            }
        }
        int[] res = {start, end};
        return res;
    }

    class Truple{
        int val;
        int row;
        int col;

        Truple(int val, int row, int col){
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }
}
