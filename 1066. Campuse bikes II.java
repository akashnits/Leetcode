class Solution {
    public int assignBikes(int[][] workers, int[][] bikes) {
        int n = bikes.length;
        int m = workers.length;
        int bikeUsedMask = 0;

        Map<String, Integer> dp = new HashMap();
        
        return minSumDistance(workers, bikes, 0, bikeUsedMask, dp);
    }
    
    
    int minSumDistance(int[][] workers, int[][] bikes, int workerIdx, int bikeUsedMask, Map<String, Integer> dp){
        // base condition --  no more workers
        if(workerIdx == workers.length){
            return 0;
        }

        String key = workerIdx + "," + bikeUsedMask;
        
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        
        int minDistance = Integer.MAX_VALUE;
        // choices - this worker can be given any of the un-assigned bikes
        for(int i=0; i < bikes.length; i++){
            int[] bike = bikes[i];
            int[] worker = workers[workerIdx];
            // check if this bike is available
            // continue if not available
            if(((bikeUsedMask >> i) & 1) == 1) continue;
               
            // mark this bike unavialable
            bikeUsedMask += (1 << i);
            
            // give this bike to this worker and calculate distance
            int distance = Math.abs(bike[0] - worker[0]) + Math.abs(bike[1] - worker[1]); 
            
            // recurse on our decision   
            int sumDistance = distance + minSumDistance(workers, bikes, workerIdx+1, bikeUsedMask, dp);
            
            // find the minDistance among all assignment
            minDistance = Math.min(minDistance, sumDistance);   
            // mark this bike available    
            bikeUsedMask -= (1 << i);
        }
        dp.put(key, minDistance);
        return minDistance; 
    }
}
