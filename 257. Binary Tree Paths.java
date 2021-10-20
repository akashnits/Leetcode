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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList();
        traverse(root, result, "");
        return result;
    }
    
    void traverse(TreeNode root, List<String> result, String curr){
        //base condition
        if(root == null)
            return;
                
        curr = curr + root.val;
        
        if(isLeafNode(root)){
            // add curr to result
            result.add(curr);
        }else{
           curr = curr + "->"; 
        }
        
        traverse(root.left, result, curr);
        
        traverse(root.right, result, curr);
    }
    
    private boolean isLeafNode(TreeNode node){
        return node.left == null && node.right == null;
    }
    
}
