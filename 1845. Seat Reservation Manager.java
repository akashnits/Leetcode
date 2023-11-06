class SeatManager {

    PriorityQueue<Integer> unreservedSeats;
    int lastOccupiedSeat = 0;

    public SeatManager(int n) {
        unreservedSeats = new PriorityQueue<Integer>((a, b) -> a-b);
    }
    
    public int reserve() {
        if(unreservedSeats.isEmpty()){
            // occupy the seat
            return ++lastOccupiedSeat;
        }

        // we have some unreserved seats
        return unreservedSeats.poll();
    }
    
    public void unreserve(int seatNumber) {
        // keep track of unserved seat in pq
        unreservedSeats.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
