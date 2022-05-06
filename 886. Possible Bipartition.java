class Solution {
    
    
    ArrayList<ArrayList<Integer>> graph;
    boolean[] visited;
    int[] color;
    
    public boolean possibleBipartition(int n, int[][] dislikes) {
        // create a adajacency list
        
        graph= new ArrayList();
        visited = new boolean[n+1];
        color = new int[n+1];
        
        for(int i=0; i<= n; i++){
            graph.add(new ArrayList());
        }
        
        // start adding edge by looping over dislikes
        for(int[] row: dislikes){
            int u = row[0];
            int v = row[1];
            
            // adding edges
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        
        // loop for all non-visited nodes
        for(int k=1; k <= n; k++){
            if(!visited[k] && !isBiPartite(k, 0)){
                return false;   
            }
        }
        return true;
    }
    
    
    private boolean isBiPartite(int v, int c){
        visited[v] = true;
        color[v] = c;
        
        for(int child: graph.get(v)){
            
            if(!visited[child]){
                if(!isBiPartite(child, c ^ 1)){
                    return false;
                }
            }else{
                // we compare color of parent with child
                if(color[v] == color[child]){
                    return false;
                }
            }
        }
        
        return true;
    }
}
