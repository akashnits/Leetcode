class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        // Binary search for minimum time
        long start = 1;

        // Find the fastest bus time (minimum time)
        int minTime = Integer.MAX_VALUE;
        for (int t : time) {
            minTime = Math.min(minTime, t);
        }

        long end = (long) minTime * totalTrips;

        long res = -1;
        // Binary search in the answer range
        while (start <= end) {
            long mid = start + (end - start) / 2;

            if (canCompleteGivenTrips(time, totalTrips, mid)) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    boolean canCompleteGivenTrips(int[] time, int totalTrips, long t) {
        // Calculate how many trips can be completed in the given time
        long tripsCompleted = 0;
        for (int busTime : time) {
            tripsCompleted += t / busTime;
            // Early exit if we've already met the required trips
            if (tripsCompleted >= totalTrips) {
                return true;
            }
        }
        return tripsCompleted >= totalTrips;
    }
}
