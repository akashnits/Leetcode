class Solution {

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> revAdj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            revAdj.add(new ArrayList<>());
        }

        // Build graph and reverse graph
        for (int[] invocation : invocations) {
            int u = invocation[0];
            int v = invocation[1];

            adj.get(u).add(v);
            revAdj.get(v).add(u);
        }

        // 1. Find all suspicious methods reachable from k
        boolean[] suspicious = new boolean[n];
        findSuspicious(adj, k, suspicious);

        // 2. Multi-source BFS on reverse graph
        // Start from ALL suspicious nodes.
        // If we reach a non-suspicious node, then that node
        // can eventually invoke a suspicious method.
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();

        // add all suspicious nodes to queue
        for (int i = 0; i < n; i++) {
            if (suspicious[i]) {
                queue.offer(i);
                visited[i] = true;
            }
        }

        while (!queue.isEmpty()) {

            int node = queue.poll();

            // A non-suspicious node can reach a suspicious node.
            // Therefore no suspicious methods cannot be removed
            if (!suspicious[node]) {
                return allMethods(n);
            }

            for (int neighbor : revAdj.get(node)) {

                if (visited[neighbor]) {
                    continue;
                }

                visited[neighbor] = true;
                queue.offer(neighbor);
            }
        }

        // No non-suspicious node can reach a suspicious node.
        // Remove all suspicious methods.
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                result.add(i);
            }
        }

        return result;
    }

    private void findSuspicious(List<List<Integer>> adj, int node, boolean[] suspicious) {

        suspicious[node] = true;

        for (int neighbor : adj.get(node)) {

            if (suspicious[neighbor]) {
                continue;
            }

            findSuspicious(adj, neighbor, suspicious);
        }
    }

    private List<Integer> allMethods(int n) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            result.add(i);
        }

        return result;
    }
}
