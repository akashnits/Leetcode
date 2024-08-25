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
    List<List<Integer>> res;
    public List<List<Integer>> findLeaves(TreeNode root) {
        res = new ArrayList();
        collectLeaves(root);
        return res;
    }

    int collectLeaves(TreeNode root){
        if(root == null){
            return -1;
        }

        int leftLevel = collectLeaves(root.left);
        int rightLevel = collectLeaves(root.right);

        int currentLevel = 1 + Math.max(leftLevel, rightLevel);

        if(currentLevel > res.size()-1){
            res.add(new ArrayList());
        }

        res.get(currentLevel).add(root.val);

        return currentLevel;
    }

}
