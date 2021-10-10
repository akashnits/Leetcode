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
    public int countNodes(TreeNode root) {
        // Base Case
    if (root == null)
        return 0;
 
    // Find the left height and the
    // right heights
    int lh = left_height(root);
    int rh = right_height(root);
 
    // If left and right heights are
    // equal return 2^height(1<<height) -1
    if (lh == rh)
        return (1 << lh) - 1;
 
    // Otherwise, recursive call
    return 1 + countNodes(root.left)
           + countNodes(root.right);
    }
    
    
    public int left_height(TreeNode node)
        {
            int ht = 0;
            while (node!=null) {
            ht++;
            node = node.left;
        }
 
        // Return the left height obtained
        return ht;
        }
 
    
     public int right_height(TreeNode node){
        int ht = 0;
        while (node!=null) {
        ht++;
        node = node.right;
        }
 
        // Return the right height obtained
        return ht;
        }
    
    
    
}
