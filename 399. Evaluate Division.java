class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // build a graph
        Map<String, List<GraphNode>> graph = new HashMap();

        int n = equations.size();
        for(int i=0; i < n; i++){
            List<String> variables = equations.get(i);
            String u = variables.get(0);
            String v = variables.get(1);

            // edge from u -> v and v -> u
            double w1 = values[i];
            double w2 = 1.0 / values[i];

            graph.putIfAbsent(u, new ArrayList());
            graph.putIfAbsent(v, new ArrayList());

            graph.get(u).add(new GraphNode(v, w1));
            graph.get(v).add(new GraphNode(u, w2));
        }

        List<Double> res = new ArrayList();
        // loop over queries and call dfs
        for(List<String> query: queries){
            String var1 = query.get(0);
            String var2 = query.get(1);

            // when either of the variables doesn't exist in the graph
            if(!graph.containsKey(var1) || !graph.containsKey(var2)){
                res.add(-1.0);
                 // can't be determined
                continue;
            }

            // both the variables exist in the graph, calculate path from var1 to var2
            // by using dfs
            res.add(dfs(graph, var1, var2, new HashSet()));
        }
        return res.stream().mapToDouble(Double::doubleValue).toArray();
    }


    double dfs(Map<String, List<GraphNode>> graph, String curr, String var2, Set<String> visited){
        if(curr.equals(var2)){
            // reached destination
            return 1.0;
        }

        // mark visited
        visited.add(curr);

        for(GraphNode neighbor: graph.get(curr)){
            if(!visited.contains(neighbor.var)){
                double product = dfs(graph, neighbor.var, var2, visited);
                if(product  != -1.0){
                    return neighbor.weight * product;
                }
            }
        }
        return -1.0;
    }
}

class GraphNode{
    String var;
    double weight;

    GraphNode(String var, double weight){
        this.var = var;
        this.weight = weight;
    }
}
