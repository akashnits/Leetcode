class Solution {
    int STATE_MAX;
    int V;
    boolean[][] visited;

    public int shortestPathLength(int[][] graph) {
        
        V = graph.length; // number of nodes in the graph
        if( V < 2) return 0; // edge case

        STATE_MAX= (1 << V);
        // create a queue and do bfs from all nodes simultaneously
        Queue<Pair<Integer, Integer>> queue= new ArrayDeque<Pair<Integer, Integer>>();
        visited = new boolean[V][STATE_MAX];

        // loop through all the graph nodes and make it src i.e. add Pair to the queue
        for(int v=0; v < V; v++){
            int state = (1 << v);
            Pair p = new Pair(v, state);
            // add to queue
            queue.offer(p);
            // add to set
            visited[v][state] = true;
        }

        return bfsGraph(queue, graph);
        
    }


    int bfsGraph(Queue<Pair<Integer, Integer>> queue, int[][] graph){
        int res = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            res++;
            while(size > 0){
                Pair<Integer, Integer> parentPair = queue.poll();
                size--;
                // check if we traversed all the nodes
                if(parentPair.getValue() == STATE_MAX-1){
                    return res-1;
                }
                // do a bfs on neighbors on this level
                int[] neighbors= graph[parentPair.getKey()];

                for(int neighbor: neighbors){
                    // for each neighbor we calculate the state
                    int neighborState = (1 << neighbor);
                    int nextState = (neighborState | parentPair.getValue());

                    // check if this is visited
                    if(!visited[neighbor][nextState]){
                        queue.offer(new Pair(neighbor, nextState));
                        visited[neighbor][nextState] = true;
                    }                    
                }
            }
        }
        return res;
    }
}
