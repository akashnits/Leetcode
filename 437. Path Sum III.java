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
    // we need to evaluate path with each node as root
    public int pathSum(TreeNode root, int targetSum) {
        
        if(root == null)
            return 0;
        
        return solve(root, targetSum);
    }
    
    // make each node root for findPath
    private int solve(TreeNode root, int targetSum){
        if(root == null){
            return 0;
        }
        
        // traverse the tree
        return findPath(root, targetSum) +
               solve(root.left, targetSum) +
               solve(root.right, targetSum);
    }
    
    
    // find path with targetSum equals root to any node
    private int findPath(TreeNode root, int targetSum){
        if(root == null){
            return 0;
        }
        
        int result = findPath(root.left, targetSum - root.val) + findPath(root.right, targetSum - root.val);
        
        
        return targetSum == root.val ? ++result : result;
    }
    
    
}
