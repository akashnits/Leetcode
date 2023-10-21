class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        // create adjacency list
        List<List<Integer>> graph = new ArrayList();

        for(int i=0; i < n; i++){
            graph.add(new ArrayList());
        }

        int[] indegree = new int[n];
        int[] maxTime = new int[n];

        // add edges
        for(int[] relation: relations){
            graph.get(relation[0]-1).add(relation[1]-1);
            indegree[relation[1]-1]++;
        }

        // it's a DAG, use toposort
        Queue<Integer> queue = new ArrayDeque();
        for(int i=0; i < n; i++){
            if(indegree[i] == 0){
                queue.add(i);
                maxTime[i] = time[i];
            }
        }


        return minNumMonths(queue, indegree, graph, n, time, maxTime);
    }

    int minNumMonths(Queue<Integer> queue, int[] indegree, List<List<Integer>> graph, int n, int[] time, int[] maxTime){
        int res =0;
        while(!queue.isEmpty()){
            int polled = queue.poll();
            for(int neighbor: graph.get(polled)){
                maxTime[neighbor] = Math.max(maxTime[neighbor], maxTime[polled] + time[neighbor]);
                if(--indegree[neighbor] == 0){
                    queue.add(neighbor);
                }
            }
        }
        for (int node = 0; node < n; node++) {
            res = Math.max(res, maxTime[node]);
        }
        return res;
    }


}
