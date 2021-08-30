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

// write code for calculating height of tree with one addition check of balanced binary tree
// i.e. Math.abs(lh-rh) > 1
class Solution {
    boolean result= true;
    public boolean isBalanced(TreeNode root) {
        height(root);
        return result;
    }
    
    
    public int height(TreeNode root){
        
        //base condition
        if(root == null || !result)
            return -1;
        
        
        
        int lh = height(root.left);
        int rh = height(root.right);
        
        if(Math.abs(lh - rh ) > 1){
           result = false; 
        }
        
        return 1 + Math.max(lh, rh);
    }
}
