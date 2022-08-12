/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null){
            return null;
        }
        
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        
        return root;
        
        
    }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return solve(root, Math.min(p.val, q.val), Math.max(p.val, q.val));
    }
    
    
    TreeNode solve(TreeNode root, int p, int q){
        
        // base condition
        if(root == null){
            return null;
        }
        
        if( root.val == p || root.val == q ){
            return root;
        }
        
        if(root.val > p && root.val < q){
            return root;
        }
        
        if(root.val > q){
            // go left
            return solve(root.left, p, q);
        }else{
            // go right
            return solve(root.right, p, q);
        }
        
    }
}
