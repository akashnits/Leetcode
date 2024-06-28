class Solution {
    public long maximumImportance(int n, int[][] roads) {
        // create in-degree array
        int[] indegree = new int[n]; // nodes labelled from 0 ... n
        // loop over edges
        for(int[] edge: roads){
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }

        // create a maxHeap of nodes (label) based on indegree
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> indegree[a] - indegree[b]);
        for(int v=0; v < n; v++){
            minHeap.add(v);
        }

        int[] weight = new int[n];

        int currWeight = 1;
        while(!minHeap.isEmpty()){
            weight[minHeap.poll()] = currWeight;
            currWeight++;
        }

        long sum =0;

        // traverse the graph and add weights for each path only once
        for(int[] road: roads){
            sum += weight[road[0]] + weight[road[1]];
        }
        return sum;
    }
}
