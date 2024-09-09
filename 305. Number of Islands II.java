class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        // represent row, col in node
        // node = n * row + col
        List<Integer> res = new ArrayList();

        int maxIslands = m * n;
        DSU dsu = new DSU(maxIslands);

        for(int[] position: positions){
            int row = position[0];
            int col = position[1];
            int node = row * n + col;
            // add this land and find number of connected components
            boolean isLandAdded = dsu.addLand(node);
            if(isLandAdded){
                // run union with neighbors and save count of connected islands
                for(int[] dir: dirs){
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    // try union if not out of bounds
                    if(newRow < 0 || newRow > m-1 || newCol < 0 || newCol > n-1){
                        continue;
                    }
                    int neighbor = newRow * n + newCol;
                    dsu.union(node, neighbor);
                }
            }
            res.add(dsu.islandCount);
        }
        return res;
    }

    class DSU{
        int[] parent;
        int[] rank;
        int islandCount;

        DSU(int n){
            islandCount = 0;
            parent = new int[n];
            rank = new int[n];
            for(int i=0; i < n; i++){
                parent[i] = -1; // represents water
            }
        }

        boolean addLand(int i){
            if(parent[i] == -1){
                // we have water here, add land
                parent[i] = i;
                islandCount++;
                return true;
            }else{
                // we already have land here, no change
                return false;
            }
        }

        int find(int i){
            if(i == -1){
                return -1;
            }
            if(parent[i] == i){
                return i;
            }

            return parent[i] = find(parent[i]);
        }

        void union(int x, int y){
            // union only if neighbor is land
            if(parent[y] == -1){
                return;
            }

            int xParent= find(x);
            int yParent= find(y);

            if( xParent == yParent ){
                // already connected island
                return;
            }else if(rank[xParent] > rank[yParent]){
                // connect islands
                islandCount--;
                parent[yParent] = xParent;
            }else if(rank[xParent] < rank[yParent]){
                // connect islands
                islandCount--;
                parent[xParent] = yParent;
            }else{
                // connect islands
                islandCount--;
                parent[xParent] = yParent;
                rank[yParent]++;
            }            
        }
    }
}
