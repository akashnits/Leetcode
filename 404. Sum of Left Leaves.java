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
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

    int dfs(TreeNode root, boolean isLeft){
        if(root == null){
            return 0;
        }

        int sum =0;

        if(isLeft && isLeafNode(root)){
            return root.val;
        }

        sum += dfs(root.left, true) + dfs(root.right, false);
        

        return sum;
    }

    boolean isLeafNode(TreeNode root){
        return (root.left == null && root.right == null);
    }
}
