class Solution {
    
    ArrayList<ArrayList<Integer>> graph;
    int[] visited; // 0 -> unvisited, 1 -> under_process, 2 -> completed 
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int n = numCourses;
        graph = new ArrayList();
        visited= new int[n];
        // create directed graph from given pre-requisities
        for(int i=0; i < n; i++){
            graph.add(new ArrayList());
        }
        
        for(int[] row: prerequisites){
            int u = row[0];
            int v= row[1];
            // add edge - directed graph
            graph.get(v).add(u);
        }
        
        for(int k=0; k < n; k++){
            if(visited[k] == 0 && isDeadLocked(k)){
                return false;
            }
        }
        return true;   
    }
    
    // anytime we come across a vertex which is under process, we know that
    // we have reached it from decendant, hence deadlock/loop
    private boolean isDeadLocked(int v){
        visited[v] = 1; // under process
        for(int child: graph.get(v)){
            if(visited[child] == 0){ // unvisited
                if(isDeadLocked(child)){
                    return true;
                } 
            }else{
                // it's visited and under process
                if(visited[child] == 1){
                    return true;
                }
                
            }
        }
        visited[v] = 2;
        return false;
    }
}
