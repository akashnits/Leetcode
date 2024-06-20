class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // capacity of ship should be atleast max(weights)
        int n = weights.length;
        int minCapacity = -1;
        int maxCapacity = 0;
        for(int i=0; i < n ; i++){
            minCapacity = Math.max(weights[i], minCapacity);
            maxCapacity += weights[i];
        }

        int res = -1;
        // capacity ranges from minCapacity (maxWeight) to maxCapacity sum(weights)
        while(minCapacity <= maxCapacity){
            int capacity = minCapacity + (maxCapacity - minCapacity)/2;
            // explore for this capacity if we cah ship in given days
            if(canShipWithinGivenDays(weights, days, capacity)){
                res = capacity;
                // move left
                maxCapacity = capacity-1;
            }else{
                // move right
                minCapacity = capacity +1;
            }
        }
        return res;
    }

    boolean canShipWithinGivenDays(int[] weights, int days, int capacity){
        int daysTaken = 0;
        int n = weights.length;
        int i=0;
        while(i < n){
            int currCapacity = capacity; 
            while(i < n && currCapacity >= weights[i]){
                // load it
                currCapacity -= weights[i];
                i++;
            }
            // dispact this ship
            daysTaken++;
        }
        return daysTaken <= days;
    }
}
