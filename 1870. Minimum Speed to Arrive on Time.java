class Solution {
    // Approach: Binary seach on the answer i.e. speed in this case
    int minSpeed = -1;
    boolean foundMinSpeed = false;
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        int givenTime = (int) Math.ceil(hour);

        if( n > givenTime ){
            return minSpeed;
        }

        // lets say we don't know that the given limit is 10000000
        findMinSpeedBinarySearch(dist, 1, 10000, hour);
        return minSpeed;
    }

    void findMinSpeedBinarySearch(int[] dist, int start, int end, double hour){
        // we don't change decision space if once we've found the min speed in the given range
        if(start > end){ 
            if(foundMinSpeed){
                return;
            }else {
                // we need to update the decision space
                start = end;
                end = end * 2;
            }
        } 

        int mid = start + (end - start)/2;

        double time = calculateTimeTaken(dist, mid);
        if( time <= hour){
            // we save the speed, try going to left to find further min speed
            minSpeed = mid;
            foundMinSpeed = true;
            findMinSpeedBinarySearch(dist, start, mid-1, hour);
        } else{
            // go right
            findMinSpeedBinarySearch(dist, mid+1, end, hour);
        }
    }



    double calculateTimeTaken(int[] dist, int speed){
        double time = 0.0;
        for (int i = 0 ; i < dist.length; i++) {
            double t = (double) dist[i] / (double) speed;
            // Round off to the next integer, if not the last ride.
            time += (i == dist.length - 1 ? t : Math.ceil(t));
        }
        
        return time;
    }



}
