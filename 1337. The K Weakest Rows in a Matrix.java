class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        // count of soldiers in each row
        int n = mat.length;
        // map from row index to soldiers coubt
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]);

        for(int i=0; i < n; i++) {
            int[] row = mat[i];
            int soldiersCount = 0;
            for(int j: row){
                soldiersCount += j;
            }
            int[] pair = new int[2];
            pair[0] = i;
            pair[1] = soldiersCount;
            maxHeap.offer(pair) ;
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        int[] res = new int[k];
        int idx = k-1;
        while(!maxHeap.isEmpty() && idx > -1){
            int[] ele = maxHeap.poll();
            res[idx] = ele[0];
            idx--;
        }

        return res;
    }
}
