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
    public boolean evaluateTree(TreeNode root) {
        // 0 -> false, 1 -> true, 2 -> OR , 3 -> AND
        return evaluate(root);
    }

    boolean evaluate(TreeNode root){
        // full binary tree, either leaf or have both children
        if(root.left == null && root.right == null){
            // leaf node, return the value as is
            return root.val == 1;
        }else{
            // it would have both children
            if(root.val == 2){
                return evaluate(root.left) || evaluate(root.right);
            }else{
                return evaluate(root.left) && evaluate(root.right);
            }
        }
    }
}
