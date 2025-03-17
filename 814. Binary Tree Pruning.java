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
    // traverse in post - order fashion
    // left and right subtree tell us if they contain 1 - somehow
    // or the result of left and right subtree to find the ans
    public TreeNode pruneTree(TreeNode root) {
        return prune(root);
    }


    TreeNode prune(TreeNode root){
        // base conditions:
        if(root == null){
            // this sub-tree doesn't contain 1
            return null;
        }

        root.left = prune(root.left);
        root.right = prune(root.right);

        // we don't prune if root value is 1 or any child is non- null
        if((root.left != null) ||
            (root.right != null) || (root.val == 1) ){
            return root;
        }else{
            return null;
        }
    }
}
