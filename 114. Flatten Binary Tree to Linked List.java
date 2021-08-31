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
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        
        
        flatten(root.left);
        //check if node have left child, if not, we don't need to flatten
        if(root.left != null){
            
            //detach right child and store in temp
            TreeNode temp = root.right;
            root.right = null;
            
            //attach left child to right of root and make left child null
            root.right = root.left;
            root.left= null;
            
            //attach node stored in temp at the bottom-right of new right child
            TreeNode right = root.right;
            while(right.right != null){
                right = right.right;
            }
            
            right.right = temp;
        }
        flatten(root.right);
        
    }
}
