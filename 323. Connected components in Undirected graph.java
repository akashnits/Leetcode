class Solution {
    // TC: O(V + E * a(n))
    // SC: O(V)
    public int countComponents(int n, int[][] edges) {
        int setCount = n;
        DSU dsu = new DSU(n);
        // loop over all edges and union them
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            int parentU = dsu.find(u);
            int parentV = dsu.find(v);

            if(parentU != parentV){
                // union them are they are in different sets
                dsu.union(u, v);
                setCount--;
            }
        }
        return setCount;
    }


    class DSU{
        int[] parent;
        int[] rank;

        DSU(int n){
            parent = new int[n];
            rank = new int[n];

            for(int i=0; i < n; i++){
                parent[i] = i;
            }
        }

        int find(int v){
            if(v == parent[v]){
                return v;
            }

            return parent[v] = find(parent[v]);
        }

        void union(int u, int v){
            int parentU= find(u);
            int parentV = find(v);

            if(parentU != parentV){
                if(rank[parentU] > rank[parentV]){
                    parent[parentV] = parentU;
                }else if(rank[parentU] < rank[parentV]){
                    parent[parentU] = parentV;
                }else{
                    parent[parentU] = parentV;
                    rank[parentV]++;
                }
            }
        }
    }
}
