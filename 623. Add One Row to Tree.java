/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        // handle base case
        if(depth == 1){
            // create a new node
            TreeNode newNode = new TreeNode(val);
            newNode.left= root;
            return newNode;
        }
        //normal case, depth > 1
        bfs(root, val, depth);
        return root;
    }

    void bfs(TreeNode root, int val, int depth){
        Queue<TreeNode> q= new LinkedList();
        q.offer(root);

        int level = 1;
        while(!q.isEmpty()){
            int size = q.size(); // size from the previous level
            for(int i=0; i < size; i++){
                TreeNode polled = q.poll();

                if(level == depth-1){
                    // we need to add new nodes
                    // also add link to polled.left and polled.right

                    TreeNode newLeft = new TreeNode(val);
                    TreeNode newRight = new TreeNode(val);

                    newLeft.left = polled.left;
                    newRight.right = polled.right;

                    polled.left = newLeft;
                    polled.right = newRight;

                    // add new nodes to the queue
                    // q.offer(newLeft);
                    // q.offer(newRight);
                }else{
                    // iterate normally if level != depth
                    if(polled.left != null){
                        q.offer(polled.left);
                    }

                    if(polled.right != null){
                        q.offer(polled.right);
                    }
                }
            }
            level++;
        }
    }
}
