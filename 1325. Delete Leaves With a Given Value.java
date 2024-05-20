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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        // we need process the tree from bottom to top
        // use post order traversal

        // base condition
        if(root == null){
            return null;
        }

        // remove nodes with leaf node == target in the left subtree
        root.left = removeLeafNodes(root.left, target);
        // remove nodes with leaf node == target in the right subtree
        root.right= removeLeafNodes(root.right, target);

        // we check if leaf node == target, we delete the node
        if(root.left == null && root.right == null && root.val == target){
            return null;
        }else{
            return root;
        }
    }
}
