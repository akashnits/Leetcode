class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> (b - a));

        // add all to pq
        for(int num: nums){
            maxHeap.offer(num);
        }

        long score = 0L;

        while(!maxHeap.isEmpty() && k > 0){
            int maxElement = maxHeap.poll();
            score += maxElement;

            // reduce maxElement
            int modified = (int) Math.ceil( maxElement/ 3.0 );
            if(modified > 0){
                maxHeap.offer(modified);
            }
            k--;
        }
        return score;
    }
}
