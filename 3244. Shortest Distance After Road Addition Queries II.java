class Solution {
    // approach: all queries are non-intersecting which means we can remove all
    // the edges b/w nodes after a query
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        // create a graph
        Map<Integer, Integer> graph = new HashMap();
        // last node doesn't have an edge
        for(int i=0; i< n-1; i++){
            graph.put(i, i+1);
        }

        // currently, the length of path from src to dest is graph.size()
        // as each node is poining to next node

        int idx =0;
        int[] ans = new int[queries.length];
        for(int[] query: queries){
            int start = query[0];
            int end = query[1];

            // remove if incoming edge gives a shorter route
            // how to identify if it's shorter route ?
            if(graph.containsKey(start) && end > graph.get(start)){
                // remove all edges from [start, end) 
                int edge = graph.get(start);
                while(edge < end){
                    edge = graph.remove(edge);
                }
                // now, add edge from start to end
                graph.put(start, end);
            }
            

            // size of graph - 1 would give the length of path from src to dest
            ans[idx++] = graph.size();
        }

        return ans;
    }
}
