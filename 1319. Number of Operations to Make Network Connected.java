class Solution {
    public int makeConnected(int n, int[][] connections) {
        // min number of re-connections to make it connected (same group)
        // how many components we have 
        // we need to make one component
        // if we have 3 components, we need 2 wires to connect all
        // if we have 4 components, we need 3 wires to connect all

        // the questions is do we have enough extra wires ? If yes, numComponents - 1 is the ans, else -1

        int wires = connections.length;
        // we need at least n-1 wires to fully connect
        if(wires < n-1){
            return -1;
        }

        int numComponents = n;
        // count number components
        DSU dsu = new DSU(n);
        // loop over all connection and union them
        for(int[] connection: connections){
            // we try to group connected components
            int node1 = connection[0];
            int node2 = connection[1];

            if(dsu.union(node1, node2)){
                // reduce one component as we merged
                numComponents--;
            }
        }

        // we need numComponents - 1 extra wires
        // as we know, the solution is possible as we had n-1 wires or more
        return numComponents - 1;
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

        boolean union(int x, int y){
            int parentX = find(x);
            int parentY = find(y);

            if(parentX == parentY){
                return false; // already part of same group
            }

            if(rank[parentX] > rank[parentY]){
                parent[parentY] = parentX;
            }else if(rank[parentY] > rank[parentX]){
                parent[parentX] = parentY;
            }else{
                parent[parentX] = parentY;
                rank[parentY]++;
            }
            return true;
        }
    }
}
