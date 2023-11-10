class Solution {
    List<Integer> res;
    public int[] restoreArray(int[][] adjacentPairs) {
        res= new ArrayList();

        // create a graph and do a dfs from start

        Map<Integer, List<Integer>> graph = new HashMap();

        // add edges to graph
        for(int[] edge: adjacentPairs){
            int u = edge[0];
            int v = edge[1];

            if(graph.get(u) == null){
                graph.put(u, new ArrayList());
            }

            if(graph.get(v) == null){
                graph.put(v, new ArrayList());
            }

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int root = 0;
        for (int num : graph.keySet()) {
            if (graph.get(num).size() == 1) {
                root = num;
                break;
            }
        }

        // call dfs on root
        dfs(root, graph, new HashMap());
        return res.stream().mapToInt(Integer::intValue).toArray();
    }


    void dfs(int v, Map<Integer, List<Integer>> graph, Map<Integer, Boolean> visited){
        res.add(v);
        // mark as visited
        visited.put(v, true);

        for(int neighbor: graph.get(v)){
            if(visited.get(neighbor) == null){
                dfs(neighbor, graph, visited); // not visited
            }
        }
    }
}
