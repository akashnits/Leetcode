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
    String res = null;
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return res;
    }

    void dfs(TreeNode root, StringBuilder op){
        if(root == null){
            return;
        }

        char c = (char) (root.val + 'a');
        op = op.insert(0, c);

        if(isLeaf(root)){
            // we need to compare with min string
            if(res == null){
                res = new String(op);
            }else{
                if(res.toString().compareTo(op.toString()) > 0){
                    res = op.toString();
                }
            }
        }

        dfs(root.left, op);
        dfs(root.right, op);
        op.deleteCharAt(0);
    }

    boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }
}
