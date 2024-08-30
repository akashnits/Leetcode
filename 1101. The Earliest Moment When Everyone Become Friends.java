class Solution {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (log1, log2) -> Integer.compare(log1[0], log2[0]));
        int res = -1;
        // find the earliest time when there's just one component after processing all distinct n nodes
        DSU dsu = new DSU(n);
        Set<Integer> distinctNodes = new HashSet();
        int setCount = n; // each node in different set

        for(int[] log: logs){
            int timestamp = log[0];
            int u = log[1];
            int v = log[2];

            // process these nodes
            distinctNodes.add(u);
            distinctNodes.add(v);

            // check if u, v in same set
            if(dsu.find(u) != dsu.find(v)){
                // make union
                dsu.union(u, v);
                setCount--; // decrement by 1 as we merged two sets
            }

            if(setCount == 1 && distinctNodes.size() == n){
                // we have one component
                // all distinct nodes are processed
                res = timestamp;
                break;
            }
        }
        return res;
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
            if(parent[v] == v){
                return v;
            }

            return parent[v] = find(parent[v]);
        }

        void union(int u, int v){
            int parentU = find(u);
            int parentV = find(v);

            int rankU = rank[parentU];
            int rankV = rank[parentV];

            if(parentU != parentV){
                if(rankU > rankV){
                    parent[parentV] = parentU;
                }else if(rankU < rankV){
                    parent[parentU] = parentV;
                }else{
                    // same rank
                    parent[parentU] = parentV;
                    rank[parentV]++;
                }
            }
        }
    }
}
