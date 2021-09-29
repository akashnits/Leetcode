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
    // using morris in-order traversal
    // Time complexity: O(n), space O(1)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        TreeNode curr= root;
        while(curr != null){
            // no left subtree, go on and print value
            if(curr.left == null){
                result.add(curr.val);
                curr = curr.right;
            }else{
                //we have a left sub-tree which we need to iterate
                // before doing that we need to create a link to curr so
                // that we can come back after iterating left subtree
                
                
                TreeNode rightMostInLeftTree = curr.left;
                
                // go to the right most child in left subtree
                // iterate till right is either null or curr ( we may have created a link to curr earlier) 
                
                while(rightMostInLeftTree.right != null && rightMostInLeftTree.right != curr){
                    rightMostInLeftTree= rightMostInLeftTree.right;
                }
                
                // if we have created link earlier, we need to unlink and restore tree
                // else we need to create a link to curr
                
                if(rightMostInLeftTree.right == null){
                     // link and create threaded binary tree
                    rightMostInLeftTree.right = curr;
                    curr = curr.left;
                }else{
                    // unlink and restore
                    result.add(curr.val);
                    curr= curr.right;
                    rightMostInLeftTree.right= null;
                }
                
            }
        }
        return result;
    }
}
