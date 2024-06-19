class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        // create a list of pair from profit to difficulty
        List<Pair<Integer, Integer>> list = new ArrayList();
        int n = difficulty.length;
        for(int i=0; i < n; i++){
            Pair<Integer, Integer> p = new Pair<Integer, Integer>(profit[i], difficulty[i]);
            list.add(p);
        }
        // sort this list on profit - max to min
        Collections.sort(list, (p1, p2) -> (p2.getKey() - p1.getKey()));

        // sort the capability of workers, from max to min
       Arrays.sort(worker);

        // loop over list, see if this worker could do this job
        
        int m = worker.length;
        int w = m-1;
        int res = 0;
        for(int i=0; i < n; i++){
            Pair<Integer, Integer> pair= list.get(i);
            int profitVal = pair.getKey();
            int difficultyVal = pair.getValue();

            // for this profit, compare difficulty with capabilty for worker
            while(w >= 0 && worker[w] >= difficultyVal){
                res += profitVal;
                w--;
            }
        }
        return res;
    }
}
