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
    int maxSum =Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMaxPathSum(root);
        return maxSum;
    }
    
    
    private  int findMaxPathSum(TreeNode root){
		if(root == null){
			return 0;
		}
		
		int leftSubtreeSum = Math.max(0, findMaxPathSum(root.left));
		int rightSubtreeSum = Math.max(0, findMaxPathSum(root.right));
		
		maxSum = Math.max(maxSum, root.val + leftSubtreeSum + rightSubtreeSum);
		return root.val + Math.max(leftSubtreeSum , rightSubtreeSum);
	}
}
