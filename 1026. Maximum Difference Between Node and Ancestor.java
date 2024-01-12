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
    int maxDiff =0;
    public int maxAncestorDiff(TreeNode root) {
        solve(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        return maxDiff;
    }

    void solve(TreeNode root, int min, int max){
        if(root == null){
            return;
        }

        min = Math.min(root.val, min);
        max = Math.max(root.val, max);

        maxDiff = Math.max(Math.abs(min-max), maxDiff);

        solve(root.left, min, max);
        solve(root.right, min, max);

    }
}
