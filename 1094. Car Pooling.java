class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // at no location , number of passengers > capacity
        // track number of passengers at each location

        // keeps track of location to number of passengers
        Map<Integer, Integer> map = new TreeMap();

        // trips sorted by location
        for(int[] trip: trips){
            int passengers = trip[0];
            int onboardAt = trip[1];
            int deboardAt = trip[2];

            map.put(onboardAt, map.getOrDefault(onboardAt, 0) + passengers);
            map.put(deboardAt, map.getOrDefault(deboardAt, 0) - passengers);
        }

        int usedCapacity =0;
        for(int passengerChanges: map.values()){
            usedCapacity += passengerChanges;
            if(usedCapacity > capacity){
                return false;
            }
        }
        return true;
    }
}
