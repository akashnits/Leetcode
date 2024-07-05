import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // Sort meetings as per start time - meeting with earlier meeting time gets precedence
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Create an array for meeting room booking frequency
        int[] mrBookingFreq = new int[n];
        
        // Keeps track of available rooms, sorted by room number
        PriorityQueue<Integer> availableRoomsMinHeap = new PriorityQueue<>();
        for (int room = 0; room < n; room++) {
            availableRoomsMinHeap.offer(room);
        }
        
        // Use a priority queue sorted on end times, if end time clash sort by room number
        PriorityQueue<Meeting> onGoingMeetingMinHeap = new PriorityQueue<>((a, b) -> 
            (a.endTime == b.endTime ? (a.roomNumber - b.roomNumber) : 
            (a.endTime - b.endTime)));
        
        for (int[] meeting : meetings) {
            int startTimeNextMeeting = meeting[0];
            
            // Free any rooms where meetings have ended by the start time of the next meeting
            while (!onGoingMeetingMinHeap.isEmpty() && onGoingMeetingMinHeap.peek().endTime <= startTimeNextMeeting) {
                // End the meeting and add room to availableRoomsMinHeap
                Meeting meetingToEnd = onGoingMeetingMinHeap.poll();
                availableRoomsMinHeap.offer(meetingToEnd.roomNumber);
            }
            
            // Start next meeting in any of the available rooms
            if (!availableRoomsMinHeap.isEmpty()) {
                int roomNumberForMeeting = availableRoomsMinHeap.poll();
                int endTimeNextMeeting = meeting[1];
                onGoingMeetingMinHeap.offer(new Meeting(roomNumberForMeeting, endTimeNextMeeting));
                mrBookingFreq[roomNumberForMeeting]++;
            } else {
                // No meeting room available at the start time of the next meeting
                // Delay the meeting
                Meeting earliestEndingMeeting = onGoingMeetingMinHeap.poll();
                int roomNumberForMeeting = earliestEndingMeeting.roomNumber;
                int newStartTime = earliestEndingMeeting.endTime;
                int newEndTime = newStartTime + (meeting[1] - meeting[0]);
                onGoingMeetingMinHeap.offer(new Meeting(roomNumberForMeeting, newEndTime));
                mrBookingFreq[roomNumberForMeeting]++;
            }
        }
        
        // Loop over mrBookingFreq and return the meeting room which hosted the maximum meetings
        int maxMeetingsHosted = 0;
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (mrBookingFreq[j] > maxMeetingsHosted) {
                maxMeetingsHosted = mrBookingFreq[j];
                res = j;
            }
        }
        
        return res;
    }

    class Meeting {
        public int roomNumber;
        public int endTime;

        Meeting(int roomNumber, int endTime) {
            this.roomNumber = roomNumber;
            this.endTime = endTime;
        }
    }
}
