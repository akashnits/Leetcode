class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        // create priority queue - maxHeap as per distance from origin
        PriorityQueue<Pair<Integer, Integer>> pq = new 
            PriorityQueue<Pair<Integer, Integer>>((p2, p1) -> 
                          ((p1.getKey()) * (p1.getKey()) + (p1.getValue()) *                                     (p1.getValue())) -  
                          ((p2.getKey()) * (p2.getKey()) + (p2.getValue()) *                                      (p2.getValue())));
        
        
        for(int[] point: points){
            pq.offer(new Pair(point[0], point[1]));
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        int[][] result = new int[k][2];
        int row=0;
        while( k-- > 0){
            Pair<Integer, Integer> pair= pq.poll();
            result[row][0] = pair.getKey();
            result[row][1] = pair.getValue();
            row++;
        }
        return result;
    }
}
