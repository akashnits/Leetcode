/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Idea: Two scenarios: 
// 1. A subtree contains both the nodes, that means root of that subtree is LCA
// 2. Diffferent subtree contain the nodes,  root of those subtrees is LCA
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        //bas condition
        if(root == null){
            return root;
        }
        
        if(root == p || root == q){
            return root;
        }
        
        //we traverse the tree and find if nodes are contained in same subtree or different
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
            
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // if left and right both return non- null values, then scenario 2 is true
        if(left != null && right != null){
            return root;
        }
        
        return left == null ? right: left; //scenario 1
        
    }
}
