class Solution {
    // we use indegree array for this
    // for leaf vertex, indegree array size equals 1
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // create adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList();
        
        for(int i=0; i < n ; i++){
            graph.add(new ArrayList());
        }
        
        for(int[] edge: edges){
            int u= edge[0];
            int v= edge[1];
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return minHeightTrees(graph,n);
    }
    
    private List<Integer> minHeightTrees(ArrayList<ArrayList<Integer>> graph, int n){
        List<Integer> res = new ArrayList();
        
        if(n < 2){
            // edge case
            for(int i=0; i <n; i++){
                res.add(i);
            }
            return res;
        }
        
        // create indegree array and populate it
        int[] indegree = new int[n];
        Queue<Integer> leaves = new ArrayDeque<Integer>();
        
        for(int v=0; v < n ; v++){
            indegree[v] = graph.get(v).size();
            if(indegree[v] == 1){ // it's a leaf node
                leaves.add(v);
            }
        }
        
        //we run loop until count > 2
        int count = n;
        while(count > 2){
			int size = leaves.size();
            count -= size; // as we process leaves, we return count
            // iterate over all leaf node since we want to remove it
            for(int j=0; j < size; j++){
                // we trim and move inwards to find centeroid
                // as we remove leaf, indegree of it's neighbor decrement by 1
                int leaf = leaves.poll();
                for(int neighbor: graph.get(leaf)){
                    indegree[neighbor]--;
                    if(indegree[neighbor] == 1){
                        // we have found a new leaf
                        leaves.add(neighbor);
                    }
                }
            }
        }
        res.addAll(leaves);
        return res;
    }
}
