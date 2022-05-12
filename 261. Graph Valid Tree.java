class Solution {
    
    int numberVertices= 0 ;
    boolean[] visited;
    ArrayList<ArrayList<Integer>> graph;
    // check if graph is connected and acyclic using DFS
    public boolean validTree(int n, int[][] edges) {
        // construct graph 
        
        graph = new ArrayList();
        
        for(int i=0; i < n ; i++){
            graph.add(new ArrayList());
        }
        
        // add edges
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        visited = new boolean[n];
        return !dfs(0, -1) && (numberVertices == n);
    }
    
    // check for cycle
    private boolean dfs(int v, int parent){
        numberVertices++;
        visited[v] = true;
        
        for(int neighbor: graph.get(v)){
            if(!visited[neighbor]){
                if(dfs(neighbor, v)){
                    return true;
                }
            }else{
                if(neighbor != parent){
                    return true;
                }
            }
        }
        return false;
    }
}
