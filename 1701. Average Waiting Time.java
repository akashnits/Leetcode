class Solution {
    public double averageWaitingTime(int[][] customers) {
        double totalWaitTime = 0.0;
        int n = customers.length;
        int chefFreeAtTime = 0;
        for(int[] customer: customers){
            int arrivalTime = customer[0];
            int prepTime = customer[1];

            int additionalWait = chefFreeAtTime > arrivalTime ? (chefFreeAtTime - arrivalTime): 0;
            int waitTime = additionalWait + prepTime;

            totalWaitTime  += waitTime;
            chefFreeAtTime = arrivalTime + waitTime; // order ready
        }
        return (totalWaitTime / n);
    }
}
