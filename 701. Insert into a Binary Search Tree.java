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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        insertInBST(root, val);
        return root;
    }
    
    private void insertInBST(TreeNode root, int value){
			
			if(value > root.val){
                if(root.right == null){
                    root.right = new TreeNode(value);
                    return;
                }
				insertInBST(root.right, value);
			}else{
                 if(root.left == null){
                    root.left = new TreeNode(value);
                     return;
                }
				insertInBST(root.left, value);
			}
		}
}701. Insert into a Binary Search Tree
