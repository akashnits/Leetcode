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
    public TreeNode bstToGst(TreeNode root) {
        // traverse in reverse in-order fashion and keep track of sum 
        reverseInorderTraversal(root);
        return root;
    }

    int currSum = 0;
    void reverseInorderTraversal(TreeNode root){
        if(root == null){
            return;
        }


        reverseInorderTraversal(root.right);
        currSum += root.val;
        root.val = currSum;
        reverseInorderTraversal(root.left);
    }
}
