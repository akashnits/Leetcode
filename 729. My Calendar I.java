class MyCalendar {
    // approach: compare neighboring intervals
    // end of left neighbor should be <= start
    // start of right neighbor should be >= end
    // how to determine neighbors? - we do it by sorting on start time ( that's what we do in interval problems)
    TreeMap<Integer, Integer> calendar;
    public MyCalendar() {
        calendar = new TreeMap();
    }
    
    public boolean book(int start, int end) {
        
        // check if start time falls in booked time
        Integer nearestStartToLeft = calendar.floorKey(start);
        if (nearestStartToLeft != null && calendar.get(nearestStartToLeft) > start) return false;
        Integer nearestStartToRight = calendar.ceilingKey(start);
        if (nearestStartToRight != null && nearestStartToRight < end) return false;
        
        calendar.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
