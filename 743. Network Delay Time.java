class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // create a adjacency list 
        List<List<GraphNode>> adjList = new ArrayList(); // size -> n+1

        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0; // source node

        for(int i=0; i <= n; i++){
            adjList.add(new ArrayList());
        }

        // initialize adjList
        for(int[] row: times){
            GraphNode childNode = new GraphNode(row[1], row[2]);
            adjList.get(row[0]).add(childNode);
        }

        // create a minHeap 
        PriorityQueue<GraphNode> minHeap = new PriorityQueue<GraphNode>(
            (n1, n2) -> (n1.dist - n2.dist));
        minHeap.add(new GraphNode(k, 0));

        while(!minHeap.isEmpty()){
            GraphNode parent = minHeap.poll();

            // iterate it's neighbors
            for(GraphNode neighbor: adjList.get(parent.val)){
                if(distance[neighbor.val] > distance[parent.val] + neighbor.dist){
                    // update neighbor distance
                    distance[neighbor.val] =  distance[parent.val] + neighbor.dist;
                    minHeap.add(new GraphNode( neighbor.val, distance[neighbor.val]));
                }
            }
        }

        // iterate through distance array and find max value
        int res = -1;
        boolean isNodeUnreachable = false;
        for(int i=1; i<=n ;i++){
            if(distance[i] == Integer.MAX_VALUE){
                isNodeUnreachable = true;
                break;
            }
            res = Math.max(res, distance[i]);
        }


        return isNodeUnreachable ? -1: res;
    }

    class GraphNode {
        int val;
        int dist;

        GraphNode(int val, int dist){
            this.val = val;
            this.dist = dist;
        }
    }

}
