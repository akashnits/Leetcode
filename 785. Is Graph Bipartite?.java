class Solution {
    // approach: don't put node and neighbor in the same color
    // if we find node and neighbor in same color, it's not bipartite

    // define colors - {0,1,2} ; 0 -> unprocessed , 1 -> color 1, 2 -> color 2

    boolean res = true;
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length; // number of nodes
        int[] colorArr = new int[n]; // all color '0' to signify unprocessed 
        // put this in the loop as this can non-connected graph
        for(int i=0; i < n; i++){
            if(res && colorArr[i] == 0){
                graphDfs(graph, i, colorArr, 1);
            }
        }
        return res;
    }


    void graphDfs(int[][] graph, int v, int[] colorArr, int color){
        if(res == false){
            return;
        }
        // check if the node has been visited
        if(colorArr[v] != 0){
            // it's been visited, if incoming color != colorArr[v], it's not bipartite
            if(color != colorArr[v]){
                res= false;
            }
            return;
        } 
        //mark it visited by putting in a color and go on
        colorArr[v] = color;
        for(int neighbor: graph[v]){
            graphDfs(graph, neighbor, colorArr,  color == 1? 2: 1);
        }
    }
}
