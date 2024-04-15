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
    int sum =0;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root, false);

        return sum;
    }

    void dfs(TreeNode root, boolean isLeft){
        if(root == null){
            return;
        }

        dfs(root.left, true);
        if(isLeft && isLeafNode(root)){
            sum += root.val;
        }
        dfs(root.right, false);
    }

    boolean isLeafNode(TreeNode root){
        return (root.left == null && root.right == null);
    }
}
