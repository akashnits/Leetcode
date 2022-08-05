class MyCalendarTwo {
    List<int[]> events = new ArrayList();   // original events
    TreeMap<Integer, Integer> overlaps = new TreeMap(); // 2-booking overlap intervals
    // Empty constructor
    public MyCalendarTwo() {}
    
    // Book
    public boolean book(int start, int end) {
        
        // check 3-booking
        if(doesOverlap(overlaps, start, end)){
            return false;
        }
        
        // no 3-booking
        // 1. update overlaps
        for (int[] event: events) {
            if (event[0] < end && event[1] > start) {     // has an overlap, add the new 2-booking overlaps
                overlaps.put(Math.max(event[0], start), Math.min(event[1], end));                
            }
        }
        
        // 2. update events
        events.add(new int[]{start, end});
        return true;
    }
    
    
    boolean doesOverlap(TreeMap<Integer, Integer> map, int start, int end){
        // find if interval overlap with single book
        Integer prevStartTime = map.floorKey(start);
        int prevEndTime;
        if(prevStartTime != null && 
           ((prevEndTime = map.get(prevStartTime)) > start)) {
            return true;
        }
        Integer nextStartTime = map.ceilingKey(start);
        if(nextStartTime != null && end > nextStartTime ) return true;
        return false;
    }
}
