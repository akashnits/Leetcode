class Solution {
    public int minimumEffortPath(int[][] grid) {
        int[][] directions = {{-1,0}, {0,1}, {1,0}, {0,-1}};

        // lets use dijsktra algo.

        //create a absDiff array
        int m = grid.length;
        int n = grid[0].length;
        int[][] absDiffArr = new int[m][n];
        for(int[] row: absDiffArr){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        // set src aBsDiff to zero
        absDiffArr[0][0] = 0;

        // create a priority queue of nodes
        PriorityQueue<GraphNode> pq = new PriorityQueue<GraphNode>((a,b) -> a.absDiff - b.absDiff);

        //add the source to the queue
        pq.add(new GraphNode(0, 0, 0));

        while(!pq.isEmpty()){
            // poll the node
            GraphNode parent = pq.poll();
            int parentX= parent.row;
            int parentY = parent.col;

            // neighbors can be found in 8 directions

            for(int[] direction: directions){
                int neighborX = parentX + direction[0];
                int neighborY = parentY + direction[1];

                // check bounds
                if(neighborX < 0 || neighborX > m-1 || neighborY < 0 || neighborY > n-1){
                    continue;
                }

                int currAbsDiff = Math.max(absDiffArr[parentX][parentY],
                                           Math.abs(grid[parentX][parentY] - grid[neighborX][neighborY]));

                // compare absDiff
                if(absDiffArr[neighborX][neighborY] > currAbsDiff){
                    // update neighbor distance
                    absDiffArr[neighborX][neighborY] = currAbsDiff;
                    // add neighbor to pq
                    pq.add(new GraphNode(neighborX, neighborY, absDiffArr[neighborX][neighborY]));
                }
            }
        }


        return absDiffArr[m-1][n-1] == Integer.MAX_VALUE ? -1: absDiffArr[m-1][n-1];
    }


    class GraphNode{
        int row;
        int col;
        int absDiff;

        GraphNode(int row, int col, int absDiff){
            this.row = row;
            this.col = col;
            this.absDiff = absDiff;
        }
    }
}
