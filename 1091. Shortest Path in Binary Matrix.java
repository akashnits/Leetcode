class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] directions = {{-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}};

        // lets use dijsktra algo.
        // corner case
        if(grid[0][0] == 1) return -1;

        //create a distance array
        int n = grid.length;
        int[][] distance = new int[n][n];
        for(int[] row: distance){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        // set src distance to zero
        distance[0][0] = 1;

        // create a priority queue of nodes
        PriorityQueue<GraphNode> pq = new PriorityQueue<GraphNode>((a,b) -> a.dist - b.dist);

        //add the source to the queue
        pq.add(new GraphNode(0, 0, 1));

        while(!pq.isEmpty()){
            // poll the node
            GraphNode parent = pq.poll();
            int parentX= parent.row;
            int parentY = parent.col;

            // neighbors can be found in 8 directions

            for(int[] direction: directions){
                int neighborX = parentX + direction[0];
                int neighborY = parentY + direction[1];

                // check bounds or neighbor unreachable
                if(neighborX < 0 || neighborX > n-1 || neighborY < 0 || neighborY > n-1 || grid[neighborX][neighborY] == 1){
                    continue;
                }

                // compare distance
                if(distance[neighborX][neighborY] > distance[parentX][parentY]+1){
                    // update neighbor distance
                    distance[neighborX][neighborY] = 1 + distance[parentX][parentY];
                    // add neighbor to pq
                    pq.add(new GraphNode(neighborX, neighborY, distance[neighborX][neighborY]));
                }
            }
        }


        return distance[n-1][n-1] == Integer.MAX_VALUE ? -1: distance[n-1][n-1];

    }

    class GraphNode{
        int row;
        int col;
        int dist;

        GraphNode(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
}
