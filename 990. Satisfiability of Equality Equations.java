class Solution {
    // if we see - '==', it means chars belong to same group; action: union if not already done
    // if we see - '!=', it shouldn't belong to same group; find to see their parents are different, 
    // return false if same parent
    // Imp: first construct the graph and then check if parent same or different

    public boolean equationsPossible(String[] equations) {
        int n = equations.length;
        DSU dsu = new DSU(26); // lowercase chars
        List<Integer> unequalList = new ArrayList();

        for(int j=0; j < n; j++){
            String equation = equations[j];
            char x = equation.charAt(0);
            char y = equation.charAt(3);

            String opr = equation.substring(1, 3);
            int xIdx = x - 'a';
            int yIdx = y - 'a';

            if(opr.equals("==")){
                // union if not already same group
                dsu.union(xIdx, yIdx);
            }else if(opr.equals("!=")){
                unequalList.add(j);
            }
        }

        // check for unequal operators
        for(int i: unequalList){
            String equation = equations[i];
            char x = equation.charAt(0);
            char y = equation.charAt(3);

            int xIdx = x - 'a';
            int yIdx = y - 'a';
            if(dsu.find(xIdx) == dsu.find(yIdx)){
                return false; // same parent
            }
        }
        return true;
    }

    class DSU {
        int n;
        int[] parent;
        int[] rank;

        DSU(int n){
            this.n = n;
            parent = new int[n];
            rank = new int[n];

            for(int i=0; i < n; i++){
                parent[i] = i;
            }
        }

        // returns the index of the char
        int find(int v){
            if(v == parent[v]){
                return v;
            }

            return parent[v] = find(parent[v]);
        }

        // union
        void union(int x, int y){
            int parentX = find(x);
            int parentY = find(y);

            if(parentX == parentY){
                return;
            }else if(rank[parentX] > rank[parentY]){
                parent[parentY] = parentX;
            }else if(rank[parentX] < rank[parentY]){
                parent[parentX] = parentY;
            }else{
                parent[parentX] = parentY;
                rank[parentY]++;
            }
            return;
        }
    }
}
