class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // create a frequency map
        Map<Integer, Integer> map = new HashMap();

        for(int num: arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // create a minHeap based on frequency ( storing freq )
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> (a-b));

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int key = entry.getKey();
            int freq = entry.getValue();

            minHeap.offer(freq);
        }

        // we want to remove elements with least frequencies (unique integer) so that we have more duplicates elements

        while(!minHeap.isEmpty() && k >= minHeap.peek()){
            // pop this
            int freq= minHeap.poll();
            k = k-freq;
        }

        return minHeap.size();
    }
}
