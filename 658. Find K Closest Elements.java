class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<Pair<Integer, Integer>>( (a, b) -> 
         ((b.getValue()  - a.getValue()== 0) ?    
         (b.getKey() - a.getKey()) :(b.getValue() - a.getValue())));
        
        int n = arr.length;
        for(int i=0; i < n; i++){
            pq.offer(new Pair(arr[i], Math.abs(arr[i]-x)));
            
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        List<Integer> res = new ArrayList();
        while(!pq.isEmpty()){
            Pair<Integer, Integer> p = pq.poll();
            res.add(p.getKey());
        }
        
         Collections.sort(res);
        return res;
    }
}
