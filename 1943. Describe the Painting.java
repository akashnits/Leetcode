
class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        // Use line sweep algorithm with a TreeMap for events
        TreeMap<Integer, Long> events = new TreeMap<>();
        
        // Populate the TreeMap with start and end events
        for (int[] segment : segments) {
            int start = segment[0];
            int end = segment[1];
            long val = segment[2];

            events.put(start, events.getOrDefault(start, 0L) + val);
            events.put(end, events.getOrDefault(end, 0L) - val);
        }
        
        List<List<Long>> res = new ArrayList<>();
        
        long preSum = 0;
        long prev = -1;
        
        for (Map.Entry<Integer, Long> entry : events.entrySet()) {
            long curr = entry.getKey();
            
            if (preSum > 0) {
                res.add(Arrays.asList(prev, curr, preSum));
            }
            
            // Update preSum and prev
            preSum += entry.getValue();
            prev = curr;
        }
        
        return res;
    }
}
