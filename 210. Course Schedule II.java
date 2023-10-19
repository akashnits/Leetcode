class Solution {
    // use topological sort using Kahn's algo
    int[] res;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        res = new int[numCourses];
        // create adjacency list
        List<List<Integer>> graph = new ArrayList();
        int V = numCourses;

        for(int i=0; i < V; i++){
            graph.add(new ArrayList());
        }

        int[] indegree = new int[V];

        // add edges and build indegree array
        for(int[] edge: prerequisites){
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque();

        // loop over indegree array and find vertices with indegree value == 0
        for(int v=0; v < V; v++){
            if(indegree[v] == 0){
                queue.add(v);
            }
        }

        // toposort
        return toposort(queue, indegree, graph, V) ? res: new int[0];
    }

    boolean toposort(Queue<Integer> queue, int[] indegree, List<List<Integer>> graph, int V){
        int nodesVisited = 0;
        while(!queue.isEmpty()){
            int polled = queue.poll();
            res[nodesVisited++] = polled;
            // iterate its neighbor and decrease indegree
            for(int neighbor: graph.get(polled)){
                if(--indegree[neighbor] == 0){
                    queue.add(neighbor);
                }
            }
        }
        return nodesVisited == V;
    }
}
