class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        // approach 1: brute force
        // for(int[] booking: bookings){
        //     // for range in flight labels, add seats
        //     for(int label = booking[0]-1; label <= booking[1]-1; label++){
        //         ans[label] += booking[2];
        //     }
        // }

        // approach 2: line sweep         
        for(int[] booking: bookings){
            int startLabel = booking[0];
            int endLabel = booking[1];
            int seats = booking[2];

            ans[startLabel -1] += seats; 
            if(endLabel < n){
                ans[endLabel] -= seats;
            }   
        }

        for(int i=1; i < n; i++){
            ans[i] += ans[i-1];
        }
        
        return ans;
    }
}
