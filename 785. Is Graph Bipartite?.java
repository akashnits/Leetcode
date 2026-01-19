class Solution {
    // idea is to do dfs and color nodes if not visitied , check color if visited
    // so, we need colors and visited array
    // color can be represented by 0/1
    // if any two adjacent nodes could be painted by same color, graph is not bipartite
    int[] colors;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length; // number of nodes ( 0, 1, 2, ...)

        colors = new int[n]; // store colors
        Arrays.fill(colors, -1);

        // graph may be disconnected, so we start dfs at each node if not already visited
        for(int v=0; v < n; v++){
            if(colors[v] == -1){
                // not visited, we can either assign 0 or 1 - doesn't matter as it's the first node of the component
                colors[v] = 0;
                if(!dfs(graph, v, 1)) // color 1 available for neighbors
                    return false;
            }
        }
        return true;
    }


    boolean dfs(int[][] graph, int v, int paintNb){
        // find the neighbors
        int[] neighbors = graph[v];
        for(int neighbor: neighbors){
            // check if visited or not
            if(colors[neighbor] != -1){
                // color should be same as prev, else return false
                if(paintNb != colors[neighbor])
                    return false;
            }else{
                // not visited
                // color it
                colors[neighbor] = paintNb;
                // call dfs
                if(!dfs(graph, neighbor, (paintNb == 0?1: 0))){
                    return false;
                }
            }
        }
        return true;
    }
}
