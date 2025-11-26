class Solution {
    public int lastStoneWeight(int[] stones) {
        // we always smash the two heaviest stones each turn
        // maintain a pq , poll heaviest 2 and put it back each turn after smashing ?

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> (b - a));

        for(int stone: stones){
            maxHeap.offer(stone);
        }

        // for n stones there would be n-1 turns at max
        // if pq has more than 1 stone
        while(maxHeap.size() > 1){
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            // smash them
            int diff = Math.abs(stone1 - stone2);
            if(diff != 0){
                maxHeap.offer(diff);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
