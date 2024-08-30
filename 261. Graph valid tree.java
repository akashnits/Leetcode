class Solution {
    public boolean validTree(int n, int[][] edges) {
        // condition 1: number of component == 1
        // condition 2: no cycles in the graph

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // create DSU from given graph
        DisjointSetUnion dsu = new DisjointSetUnion(n);
        int setCount = n;

        // loop over adjlist - initially all nodes are apart, we perform union as we go on
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            int parentU = dsu.find(u);
            int parentV = dsu.find(v);

            if(parentU == parentV){
                return false; // cycle
            }
            // u and v are connected, should belong to same set
            // if in different set,  union them
            
            // unite them and reduce set count
            dsu.union(u, v);
            setCount--;
        }

        // all elements in the same set
       return setCount == 1;
    }


    class DisjointSetUnion{
        int[] parent;
        int[] rank;

        DisjointSetUnion(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i=0; i < n; i++){
                parent[i] = i;
            }
        }

        int find(int v) {
            if (v == parent[v]) {
                return v; // Path compression
            }

            return parent[v] = find(parent[v]);
        }

        void union(int u, int v){
            int parentU = find(u);
            int parentV = find(v);

            if(parentU != parentV){
                // we need to select a parent
                // decide parent by rank
                if(rank[parentU] > rank[parentV]){
                    parent[parentV] = parentU;
                }else if(rank[parentU] < rank[parentV]){
                    parent[parentU] = parentV;
                }else{
                    parent[parentV] = parentU;
                    rank[parentU]++;
                }
            }
        }
    }
}
