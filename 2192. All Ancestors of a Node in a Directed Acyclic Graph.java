class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        // approach 2: do topological sort using kahn's algo
        // during topological sort, ancestors are processed first in BFS fashion

        List<Set<Integer>> graph = new ArrayList();
        List<Set<Integer>> ancestorList = new ArrayList();

        for(int v=0; v < n; v++){
            graph.add(new HashSet());
            ancestorList.add(new HashSet());
        }

        int[] indegree = new int[n];
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            indegree[v]++;
        }

        int[] toposorted = new int[n];

        Queue<Integer> q = new LinkedList();
        for(int v=0; v < n; v++){
            if(indegree[v] == 0){
                q.offer(v);
            }
        }

        int i=0;
        while(!q.isEmpty()){
            int polled = q.poll();
            toposorted[i++] = polled;
            for(int neighbor: graph.get(polled)){
                if(--indegree[neighbor] == 0){
                    q.offer(neighbor);
                }
            }
        }

        // for each node find ancestors
        for(int j=0; j < n; j++){
            int node = toposorted[j];
            // loop through neighbors of node
            for(int neighbor: graph.get(node)){
                Set<Integer> ancestors = new HashSet(); // ancestors of neighbor
                // node is the ancestor of neighbor
                ancestors.add(node);
                // node's ancestor is the ancestor of neighbor
                ancestors.addAll(ancestorList.get(node));
                ancestorList.get(neighbor).addAll(ancestors);
            }
        }

        return ancestorList.stream().map(ArrayList::new).peek(Collections::sort).collect(Collectors.toList());
    }
}
