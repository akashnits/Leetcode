class Solution {
    int requiredPsuedoEdges = 0;
    public int minReorder(int n, int[][] connections) {
        // keep track of actual edges
        // keep track of psuedo egdes
        
        // res = actualEdges - psuedoEdge required to go to neighbor
        
        // create a graph
        List<List<GraphNode>> graph = new ArrayList();
        
        for(int i=0; i < n; i++){
            graph.add(new ArrayList());
        }
        
        int actualEdges = connections.length;
        // add edges and count actual edges
        for(int[] edge: connections){
            int u = edge[0];
            int v= edge[1];
            graph.get(u).add(new GraphNode(v, false));
            graph.get(v).add(new GraphNode(u, true));
        }
        
        // dfs on graph using actual and psuedo edges
        dfs(graph, 0, new boolean[n]);
        return actualEdges - requiredPsuedoEdges;
    }
    
    
    public void dfs(List<List<GraphNode>> graph, int v, boolean[] visited){
        // mark visited
        visited[v] = true;
        
        // find it's neighbors
        for(GraphNode neighbor: graph.get(v)){
            // check if it's not visited
            if(!visited[neighbor.v]){
                // did you require psuedo edge to come here ?
                requiredPsuedoEdges += neighbor.isPsuedoEdge ? 1 : 0;
                // recurse
                dfs(graph, neighbor.v, visited);
            }
        }
    }
    
    
    class GraphNode{
        int v;
        boolean isPsuedoEdge;
        
        GraphNode(int v, boolean isPsuedoEdge){
            this. v = v;
            this.isPsuedoEdge = isPsuedoEdge;
        }
    }
}
