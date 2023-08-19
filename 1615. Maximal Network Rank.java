class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        // create adjacency list

        List<Set<Integer>> graph = new ArrayList();

        for(int i=0; i< n; i++){
            graph.add(new HashSet<Integer>());
        }

        // add edges to graph
        for(int[] road: roads){
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }

        // calculate maximal network rank
        int res = 0;

        for(int i=0; i < n; i++){
            for(int j=0; j < n; j++){
                if(i == j) continue;
                int totalOutgoingEdges = graph.get(i).size() + graph.get(j).size() - (isConnected(graph, i, j) ? 1: 0);
                res = Math.max(res, totalOutgoingEdges);
            }
        }

        return res;
    }

    boolean isConnected(List<Set<Integer>> graph, int i, int j){
        return graph.get(i).contains(j);
    }
}
