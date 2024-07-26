class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // create a graph
        List<List<GraphNode>> graph = new ArrayList();
        for(int i=0; i < n; i++){
            graph.add(new ArrayList());
        }

        // add edges and weights
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            graph.get(u).add(new GraphNode(v, weight));
            graph.get(v).add(new GraphNode(u, weight));
        }

        Map<Integer, Integer> map = new HashMap();
        // start traversal from each node
        for(int v=0; v < n ; v++){
            int validNeighbors = findNeighborWithinThresold(graph, n, distanceThreshold, v);
            map.put(v, validNeighbors);
        }

        // find minimum in map values
        int minCityNum = -1;
        int minNeighborCount = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int cityNumber = entry.getKey();
            int neighborCount = entry.getValue();

            if(neighborCount < minNeighborCount){
                // update
                minNeighborCount = neighborCount;
                minCityNum = cityNumber;
            }else if(neighborCount == minNeighborCount && cityNumber > minCityNum){
                minCityNum = cityNumber;
            }
        }
        return minCityNum;
    }

    // loop through using dijkstra algo
    int findNeighborWithinThresold(List<List<GraphNode>> graph, int n, int distanceThreshold, int src){
        // create distance arr
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        // min distance nodes processed first
        PriorityQueue<GraphNode> minHeap = new PriorityQueue<GraphNode>(
            (node1, node2) -> (distance[node1.v] - distance[node2.v]));   
            
        // push the src as it has the min distance
        minHeap.offer(new GraphNode(src, 0));

        // loop through while minHeap isn't empty
        while(!minHeap.isEmpty()){
            GraphNode polledNode = minHeap.poll();
            for(GraphNode neighbor: graph.get(polledNode.v)){
                // check the distance of neighbor > currDist + edgeDistance
                if(distance[neighbor.v] > distance[polledNode.v] + neighbor.weight){
                    // we found another path
                    distance[neighbor.v] = distance[polledNode.v] + neighbor.weight;
                    // add to queue
                    minHeap.offer(neighbor);
                }
            }
        }

        int res = 0;
        // loop through distance arr and check values < distanceThreshold
        for(int v=0; v < n; v++){
            if(v == src) continue;

            if(distance[v] <= distanceThreshold){
                // valid neighbor
                res++;
            }
        }
        return res;
    }

    // graph node
    class GraphNode{
        int v;
        int weight;

        GraphNode(int v, int weight){
            this.v = v;
            this.weight = weight;
        }
    }

}
