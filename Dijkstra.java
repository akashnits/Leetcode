private int dijkstra(int[][] graph, int k, int n, int src, int dst){
        // for storing shortest path
        int[] parent = new int[n];
        parent[0]= -1;
        
        int[] cost= new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0]=0;
        
        boolean[] processed = new boolean[n];
        
        // loop over n-2 vertices (no need to cover for last vertex)
        for(int i=0; i < n-1; i++){
            int currVertex = selectMinVertex(n, cost, processed);
            processed[currVertex] = true;
            
            // relax adjacent nodes, loop over all nodes and find adjacent nodes
            for(int j=0; j < n; j++){
                if(graph[currVertex][j] != 0 && !processed[j] && 
                  (cost[j] > cost[currVertex]+ graph[currVertex][j])){
                    cost[j] = cost[currVertex] + graph[currVertex][j];
                    parent[j]= currVertex;
                }
            }
        }
        return cost[dst];
    }
    
    
    private int selectMinVertex(int n, int[] cost, boolean[] processed){
        // loop over cost array and return vertex with minCost
        int minCost= Integer.MAX_VALUE;
        int minVertex = -1;
        for(int i=0; i < n; i++){
            if(!processed[i] && cost[i] < minCost){
                minCost = cost[i];
                minVertex = i;
            }
        }
        return minVertex;
    }
