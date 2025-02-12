class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        // use toposort to identify the nodes in the loop
        List<List<Integer>> adjList = new ArrayList();

        int n = edges.length;
        for(int i=0; i <= n; i++){
            adjList.add(i, new ArrayList());
        }

        int[] indegree = new int[n+1];

        // add edges
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
            indegree[u]++;
            indegree[v]++;
        }

        // find all nodes with indegree 1 and remove the edge
        Queue<Integer> queue = new LinkedList();
        for(int i=1; i <=n ; i++){
            if(indegree[i] == 1){
                queue.offer(i);
            }
        }

        Set<Integer> notInLoop = new HashSet();

        while(!queue.isEmpty()){
            int polled = queue.poll();
            // this node is not in loop as it's reached
            notInLoop.add(polled);

            // go to neigbors and remove edge
            for(int neighbor: adjList.get(polled)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 1){
                    queue.offer(neighbor);
                }
            }
        }

        // loop though the given edges from the end
        for(int j=n-1; j >= 0; j--){
            // check if both the nodes in this edge in the loop
            int node1 = edges[j][0];
            int node2 = edges[j][1];

            if(notInLoop.contains(node1) || notInLoop.contains(node2)){
                continue;
            }
            return new int[]{node1, node2};
        }
        return new int[]{-1, -1};
    }
}
