class Solution {
    // Approach 1: using Prim's algo to build mst and calculate sum
    // Approach 2: Using Kruskal's algo to build mst (using DSU) and calculate sum

    public int minCostConnectPoints(int[][] points) {
        // loop over points and create adj list
        int V = points.length;


        /* using Prims */
        List<List<GraphNode>> graph = new ArrayList();
        for(int i=0; i < V; i++){
            graph.add(new ArrayList<GraphNode>());
        }

        for(int i=0; i < V; i++){
            for(int j=i+1; j < V; j++){
                // create edge
                int wt = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                graph.get(i).add(new GraphNode(j, wt));
                graph.get(j).add(new GraphNode(i, wt));
            }
        }

        return calculateUsingPrims(graph, points, V);

        /* using Kruskal */
        PriorityQueue<Edge> minHeap = new PriorityQueue<Edge>((a, b) -> a.wt-b.wt);
        // loop over all the edges only once ( wt from u->v is same as wt from v->u)
        for(int i=0; i < V; i++){
            for(int j= i+1; j < V; j++){
                int wt = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                minHeap.offer(new Edge(i, j, wt));
            }
        }

        return calculateUsingKruskal(minHeap, V);


    }



    int calculateUsingKruskal(PriorityQueue<Edge> minHeap, int V){
        int cost =0;
        int[] parent = new int[V];
        // initialize parent of each node to be the node
        for(int i=0; i < V; i++){
            parent[i] = i;
        }
        DSU dsu = new DSU(parent);

        // we need to connect V-1 edges
        int edgeCount = 0;

        while(edgeCount < V-1){
            // we need find the node with min wt
            Edge currEdge = minHeap.poll();
            int u = currEdge.u;
            int v = currEdge.v;
            int wt = currEdge.wt;

            // check if different parent
            if(dsu.find(u) != dsu.find(v)){
                // union
                dsu.union(u, v);
                cost += wt;
                edgeCount++;
            }
        }
        return cost;
    }

    int calculateUsingPrims(List<List<GraphNode>> graph, int[][] points, int V){
        // number of edges V-1 for MST
        // create parent array
        int[] parent = new int[V];
        parent[0] = -1; // src node doesn't have parent

        // create dist array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0; // distance from src node is zero

        boolean[] mstSet = new boolean[V];

        PriorityQueue<GraphNode> minHeap = new PriorityQueue<GraphNode>((a, b) -> (a.wt - b.wt));
        minHeap.add(new GraphNode(0, 0)); // add src node

        // loop until nothing left in minHeap
        while(!minHeap.isEmpty()){
            // pool from minHeap
            GraphNode u = minHeap.poll(); // this is the min vertex
            mstSet[u.idx] = true; // mark it visited

            // loop through it's neighbors
            for(GraphNode v: graph.get(u.idx)){
                // case 1: the edge already exists
                // case 2: mstSet[v.idx] should be false
                // case 3: dist[v.idx] > weight of [u, v]

                if(!mstSet[v.idx] && dist[v.idx] > v.wt){
                    dist[v.idx] = v.wt;
                    parent[v.idx] = u.idx;
                    minHeap.offer(v);
                }
            }
        }

        int sum =0;
        for(int val: dist){
            sum += val;
        }
        return sum;

    }

    class Edge{
        int u;
        int v;
        int wt;

        Edge(int u, int v, int wt){
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    class GraphNode{
        int idx; // point index
        int wt;

        GraphNode(int idx, int wt){
            this.idx = idx;
            this.wt = wt;
        }
    }

    class DSU {
        int[] parent;

        DSU(int[] parent){
            this.parent = parent;
        }

        int find(int i){
            if( i == parent[i]){
                return i;
            }

            return find(parent[i]);
        }

        void union(int x, int y){
            int parent_x = find(x);
            int parent_y = find(y);

            if(parent_x != parent_y){
                // we can do union, make parent
                parent[parent_x] = parent_y;
            }
        }
    }

}
