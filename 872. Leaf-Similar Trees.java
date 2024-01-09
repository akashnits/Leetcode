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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder leaf1 = dfs(root1, new StringBuilder());
        StringBuilder leaf2 = dfs(root2, new StringBuilder());

        return leaf1.toString().equals(leaf2.toString());
    }

    StringBuilder dfs(TreeNode root, StringBuilder leaf){
        if(root == null){
            return leaf;
        }

        // check if leaf node
        if(root.left == null && root.right == null){
            leaf.append(root.val +"_");
        }
        dfs(root.left, leaf);
        dfs(root.right, leaf);
        return leaf;
    }
}
