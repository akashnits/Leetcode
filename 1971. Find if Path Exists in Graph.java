class Solution {
    boolean[] visited;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList();

        for(int i=0; i < n; i++){
            graph.add(i, new ArrayList());
        }

        // add edges
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        visited = new boolean[n];

        // call dfs from source
        return dfs(graph, source, destination);
    }

    boolean dfs(List<List<Integer>> graph, int v, int destination){
        if(v == destination){
            return true;
        }

        // mark visited
        visited[v] = true;

        for(int child: graph.get(v)){
            // call dfs if not visited
            if(!visited[child]){
                if(dfs(graph, child, destination)){
                    return true;
                }
            }
        }
        return false;
    }
}
