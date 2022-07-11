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
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList();
        traversal(root, 0);
        return result;
    }
    
    
    void traversal(TreeNode root, int level){
        
        if(root == null){
            return;
        }
        
        // Root - R-L
        
        if(level == result.size()){
            result.add(root.val);
        }
        
        traversal(root.right, level+1);
        traversal(root.left, level+1);
        
    }
}
