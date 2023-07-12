/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<List<TreeNode>> adjList = new ArrayList();
    List<Integer> res = new ArrayList();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // intialize list
        for(int i=0; i<=500; i++){
            adjList.add(new ArrayList());
        }
        // convert tree to adjacency list 
        createAdjList(root, null);

        // do a dfs/bfs and find all nodes at distacnce k
        //adjListDfs(target, k, new boolean[501]);
        adjListBfs(target, k, new boolean[501]);
        return res;
    }


    public void createAdjList(TreeNode root, TreeNode parent){
        if(root == null) return;

        // in-order traversal
        createAdjList(root.left, root);
        if(parent != null){
            // add to list
            adjList.get(root.val).add(parent);
            adjList.get(parent.val).add(root);
        }
        createAdjList(root.right, root);
    }

    public void adjListDfs(TreeNode root, int k, boolean[] visited){
        if(root == null || k < 0)
            return;
        if(k == 0){
            // add to result
            res.add(root.val);
        }    
        // mark the node as visited
        visited[root.val] = true;

        for(TreeNode children: adjList.get(root.val)){
            // check if not visited
            if(!visited[children.val]){
                adjListDfs(children, k-1, visited);
            }
        }
    }

    public void adjListBfs(TreeNode root, int k, boolean[] visited){
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            if( k < 0 ){
                return;
            }
            int levelDiameter = queue.size();
            // need to poll all nodes at level once
            for(int i=0 ; i < levelDiameter; i++){
                // mark it visited
                TreeNode polled = queue.poll();
                if( k == 0 ){
                    res.add(polled.val);
                }
                visited[polled.val] = true;
                for(TreeNode children: adjList.get(polled.val)){
                    if(!visited[children.val]){
                        // add to queue
                        queue.add(children);
                    }
                }
            }
            k--;
        }
    }

}
