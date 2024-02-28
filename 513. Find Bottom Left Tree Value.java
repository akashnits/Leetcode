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
    int res = 0, h =0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return res;
    }

    void dfs(TreeNode root, int level){
        if(root == null){
            return;
        }
        
        if (h < level){
            res = root.val;
            h = level;
        }

        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}
