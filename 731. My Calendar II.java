class MyCalendarTwo {
    // Approach: use line sweep algorithm
    // use map instead of arr to keep track of events
    // when events come add +1 , substract when they leave -1
    // prefixSum would give the number of events at that point in time
    // check if prefixSum <= allowedOverBooking


    // stores mapping from time -> +1 or -1 depending on event is entering or leaving
    TreeMap<Integer, Integer> calendarMap;
    int allowedBooking = 2;
    public MyCalendarTwo() {
        calendarMap = new TreeMap();
    }
    
    public boolean book(int start, int end) {
        // step 1
        calendarMap.put(start, calendarMap.getOrDefault(start, 0) + 1);
        calendarMap.put(end, calendarMap.getOrDefault(end, 0) - 1);

        // loop over all entries in the map 
        // calculate prefixSum 
        // if prefixSum at any point > allowedBooking, this booking isn't allowed
        // else it's allowed

        int overlappedBookingCount = 0;
        for(Map.Entry<Integer, Integer> interval: calendarMap.entrySet()){
            overlappedBookingCount += interval.getValue();
            if(overlappedBookingCount > allowedBooking){
                // undo step 1
                calendarMap.put(start, calendarMap.getOrDefault(start, 0) - 1);
                calendarMap.put(end, calendarMap.getOrDefault(end, 0) + 1);
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
