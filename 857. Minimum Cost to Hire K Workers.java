class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        // rate would be decide by the kth worker 
        // calculate rate to hire kth costiliest worker
        int n = quality.length;
        Worker[] workers = new Worker[n];
        
        for(int i=0; i < n ; i++){
            workers[i] = new Worker(wage[i], quality[i]);
        }

        // sort the array based on rates 
        Arrays.sort(workers, (w1, w2) -> Double.compare(((double) w1.wage/w1.quality), 
                                                        ((double) w2.wage/w2.quality)));



        PriorityQueue<Integer> maxHeapQuality = new PriorityQueue<Integer>((a, b) -> (b-a));
        // add all qualities till k index and keep track of currQuality
        int currQuality = 0;

        for(int i=0; i < k; i++){
            maxHeapQuality.offer(workers[i].quality);
            currQuality += workers[i].quality;
        }

        // find the minCost
        double minCost = currQuality * ((double) workers[k-1].wage / workers[k-1].quality);
        // find cost by selecting rates from kthCostliestWorkerIdx to n
        for(int i= k; i < n; i++){
            double rate = (double) workers[i].wage / workers[i].quality;
            maxHeapQuality.offer(workers[i].quality);
            currQuality += workers[i].quality;
            if(maxHeapQuality.size() > k){
                // pop and reduce the quality from currQuality
                currQuality -= maxHeapQuality.poll();
                // calculate cost and find min
                minCost = Math.min(minCost, rate * currQuality);
            }
        }
        return minCost;                                             
    }

    class Worker{
        int wage;
        int quality;

        Worker(int wage, int quality){
            this.wage = wage;
            this.quality = quality;
        }
    }
}
