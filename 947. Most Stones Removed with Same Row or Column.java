class Solution {
    Set<String> visited;
    public int removeStones(int[][] stones) {
        Map<String, List<GraphNode>> graph = new HashMap();
        
        int m = stones.length;
        int n = stones[0].length;
        visited = new HashSet();

       // loop over all stones and add empty list
       for(int[] stone: stones){
            String key = stone[0] + "_" + stone[1];
            graph.put(key, new ArrayList());
       }

        for(int i=0; i < m ;i++){
            for(int j=i+1; j < m; j++){
                // add edge is either one co-ordinate is same
                int[] stone1 = stones[i];
                int[] stone2 = stones[j];

                if(stone1[0] == stone2[0] || stone1[1] == stone2[1]){
                    // add edge
                    String key1 = stone1[0] + "_" + stone1[1];
                    String key2 = stone2[0] + "_" + stone2[1];
                    graph.get(key1).add(new GraphNode(stone2));
                    graph.get(key2).add(new GraphNode(stone1));
                }
            }
        }

        int count = 0;
        // do a dfs from each node of the graph to find not connected components
        for(String key: graph.keySet()){
            // convert key to coords
            int pos = key.indexOf("_");
            int x = Integer.parseInt(key.substring(0, pos));
            int y = Integer.parseInt(key.substring(pos+1));
            // dfs from each key
            if(!visited.contains(key)){
                dfs(graph, x, y);
                count++;
            }
        }
        return m - count;
    }

    void dfs(Map<String, List<GraphNode>> graph, int x, int y){
        String key = x + "_" + y;
        // mark visited
        visited.add(key);

        for(GraphNode child: graph.get(key)){
            // if not visited, mark it visited and recurse
            int childX= child.coords[0];
            int childY = child.coords[1];

            String childKey = childX + "_" + childY;
            if(!visited.contains(childKey)){
                // recurse
                dfs(graph, childX, childY);
            }
        }
    }


    class GraphNode{
        int[] coords;
        GraphNode(int[] coords){
            this.coords = coords;
        }
    }
}
