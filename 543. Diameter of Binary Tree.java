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
    int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
         maxNodes(root);
         return  result-1;  
    }
    
    
    int maxNodes(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int l= maxNodes(root.left) ;
        int r= maxNodes(root.right) ;
        
        result = Math.max(result, 1+l+r);
        return 1 + Math.max(l,r);
    }
}
