class Solution {
    public int findCircleNum(int[][] isConnected) {
        int res =0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        for(int i=0; i < n; i++){
            if(!visited[i]){
                graphDfs(i, isConnected, visited);
                res++;
            }
        }

        return res;
    }

    void graphDfs(int v, int[][] graph, boolean[] visited){
        // check if the vertex is visited
        if(visited[v]){
            return;
        }

        // mark the vertex as visited
        visited[v] = true;
        // outgoing paths from vertex v
        int[] row = graph[v];
        for(int c=0; c < graph.length; c++){
            if(c == v){
                // we don't want to traverse self here
                continue;
            }
            // we can only travel if it's reachable
            if(graph[v][c] == 1){
                graphDfs(c, graph, visited);
            }
        }
    }
}
