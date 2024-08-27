class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int src, int dest) {
        // Create a graph with adjacency list
        List<List<GraphNode>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph: add both directions since it's an undirected graph
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];

            graph.get(u).add(new GraphNode(v, prob));
            graph.get(v).add(new GraphNode(u, prob));
        }

        // Perform Dijkstra's algorithm to find the maximum probability path
        return dijkstra(graph, n, src, dest);
    }

    double dijkstra(List<List<GraphNode>> graph, int n, int src, int dest) {
        double[] probability = new double[n];
        Arrays.fill(probability, 0.0); // Initialize with the minimum probability
        probability[src] = 1.0;

        // Priority Queue to process nodes, prioritizing higher probability
        PriorityQueue<GraphNode> pq = new PriorityQueue<>((a, b) -> Double.compare(b.succProb, a.succProb));
        pq.offer(new GraphNode(src, 1.0));

        while (!pq.isEmpty()) {
            GraphNode parentNode = pq.poll();
            int parentVal = parentNode.v;
            double parentProb = parentNode.succProb;

            if(dest == parentVal){
                return probability[dest];
            }

            // Loop over neighbors and update probabilities
            for (GraphNode neighbor : graph.get(parentVal)) {
                double newProb = parentProb * neighbor.succProb;

                if (newProb > probability[neighbor.v]) {
                    probability[neighbor.v] = newProb;
                    pq.offer(new GraphNode(neighbor.v, newProb));
                }
            }
        }

        // Return the probability to reach the destination
        return probability[dest];
    }

    // Helper class to represent a node in the graph with its probability
    class GraphNode {
        int v;
        double succProb;

        GraphNode(int v, double succProb) {
            this.v = v;
            this.succProb = succProb;
        }
    }
}
