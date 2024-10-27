
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        // step 1: we make events in the form -> [timeStamp, height, +1/-1]  
        List<Event> events = new ArrayList<>();
        for (int[] building : buildings) {
            // each building has 2 events - start, end
            int start = building[0];
            int end = building[1];
            int height = building[2];

            Event incoming = new Event(start, height, 1);
            Event outgoing = new Event(end, height, -1);

            events.add(incoming);
            events.add(outgoing);
        }

        // step 2: sort the events
        // for both start of building, higher height building is processed first 
        // (else we would have two critical points at the same X-coordinate)
        // for both end of building, lower height building is processed first for the same reason
        // if a building end and start at the same time, start is processed first - case 1

        Collections.sort(events, (event1, event2) -> {
            // First, compare by timestamp
            if (event1.timestamp != event2.timestamp) {
                return Integer.compare(event1.timestamp, event2.timestamp);
            }

            // At the same timestamp, prioritize start events over end events
            if (event1.flag != event2.flag) {
                return Integer.compare(event2.flag, event1.flag); // Start (1) before End (-1)
            }

            // If both are start events, sort by height (higher first)
            if (event1.flag == 1) {
                return Integer.compare(event2.height, event1.height); // Higher starts first
            } else {
                // If both are end events, sort by height (lower first)
                return Integer.compare(event1.height, event2.height); // Lower ends first
            }
        });

        // step 3: we want to calculate maxHeight for the timeStamp in events only if height changes
        // i.e. for each timestamp, first find out if it's a critical point 
        // (max height changes after adding/removing this event) 
        List<List<Integer>> res = new ArrayList<>();
        // if it does, we add it to the output
        // height -> freq
        TreeMap<Integer, Integer> maxHeightMap = new TreeMap<>();
        maxHeightMap.put(0, 1);
        int prevMaxHeight = 0;
        for (Event event : events) {
            // process the event
            if (event.flag == 1) {
                // add to map as it's incoming event
                maxHeightMap.put(event.height, maxHeightMap.getOrDefault(event.height, 0) + 1);
            } else {
                // remove from map if freq is zero
                maxHeightMap.put(event.height, maxHeightMap.get(event.height) - 1);
                if (maxHeightMap.get(event.height) == 0) {
                    maxHeightMap.remove(event.height);
                }
            }
            // check if this is a critical point, maxHeight in treemap has changed
            int currMaxHeight = maxHeightMap.lastKey() ;
            if (currMaxHeight != prevMaxHeight) {
                res.add(Arrays.asList(event.timestamp, currMaxHeight));
                prevMaxHeight = currMaxHeight;
            }
        }
        return res;
    }

    class Event {
        int timestamp;
        int height;
        int flag; // 1 for start, -1 for end of building

        Event(int timestamp, int height, int flag) {
            this.timestamp = timestamp;
            this.height = height;
            this.flag = flag;
        }
    }
}
