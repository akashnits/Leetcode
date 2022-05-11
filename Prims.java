private void prims(int[][] graph, int n){
        // for storing shortest path
        int[] parent = new int[n];
        parent[0]= -1;
        
        int[] distance= new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0]=0;
        
        boolean[] processed = new boolean[n];
        
        // loop over n-2 vertices (no need to cover for last vertex)
        for(int i=0; i < n-1; i++){
            int currVertex = selectMinVertex(n, distance, processed);
            processed[currVertex] = true;
            
            // relax adjacent nodes, loop over all nodes and find adjacent nodes
            for(int j=0; j < n; j++){
                if(graph[currVertex][j] != 0 && !processed[j] && 
                  (distance[j] > graph[currVertex][j])){
                    distance[j] = graph[currVertex][j];
                    parent[j]= currVertex;
                }
            }
        }
        // print out parent along with vertex to get MST
    }
    
    
    private int selectMinVertex(int n, int[] distance, boolean[] processed){
        // loop over distance array and return vertex with minDist
        int minDist= Integer.MAX_VALUE;
        int minVertex = -1;
        for(int i=0; i < n; i++){
            if(!processed[i] && distance[i] < minDist){
                minDist = distance[i];
                minVertex = i;
            }
        }
        return minVertex;
    }
