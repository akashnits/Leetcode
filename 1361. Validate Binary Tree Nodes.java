class Solution {
    // Approach: Binary Tree property
    // 1. Root doesn't have a parent
    // 2. All nodes must have atmost 1 parent except root
    // 3. All nodes must be connected to the root by association
    
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        // all nodes must have at most 1 parent, root doesn't have any parent
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        // preprocessing - mark parent; return false if a node has more than one parent
        for(int i=0; i < n; i++){
            // mark parent
            int lc = leftChild[i];
            int rc = rightChild[i];

            if(lc != -1){
                // if parent already not found, mark parent else return false
                if(parent[lc] != -1){
                    // more than one parent
                    return false;
                }else{
                    parent[lc] = i;
                }
            }

            if(rc != -1){
                // if parent already not found, mark parent else return false
                if(parent[rc] != -1){
                    // more than one parent
                    return false;
                }else{
                    parent[rc] = i;
                }
            }
        }

        // check count of nodes with no parent - find root
        int root = -1;
        for(int j=0; j < n ; j++){
            if(parent[j] == -1){ // node with no parent
                if(root == -1){
                    root = j;
                }else{
                    return false;
                }
            }
        }

        // no node without parent
        if(root == -1){
            return false;
        }

        // check if all nodes are connected to the root by assoication
        // we can do a dfs or bfs
        Queue<Integer> q = new ArrayDeque<Integer>();
        q.add(root);
        return findIfConnected(q, leftChild, rightChild, n);

    }

    // for a connected tree, each node must be visited just once
    boolean findIfConnected(Queue<Integer> queue, int[] leftChild, int[] rightChild, int n){
        int countNodes = 0;
        while(!queue.isEmpty()){
            int parent = queue.poll();
            countNodes++;

            // check left and right child, add to queue
            if(leftChild[parent] != -1){
                queue.add(leftChild[parent]);
            }

            if(rightChild[parent] != -1){
                queue.add(rightChild[parent]);
            }
        }
        return countNodes == n;
    }
}
