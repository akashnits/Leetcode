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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList();
        
        if(root == null)
            return result;
        
        Stack<TreeNode> s = new Stack();
        s.push(root);
        
        while(!s.isEmpty()){
            TreeNode popped= s.pop();
            result.add(popped.val);
            
            
            if(popped.right != null){
                s.push(popped.right);
            }
            
            if(popped.left != null){
                s.push(popped.left);
            }
        }
        return result;
    }
    
}
