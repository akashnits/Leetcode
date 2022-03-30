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
    int index = 0;
    int n;
    public TreeNode bstFromPreorder(int[] preorder) {
        n = preorder.length;
        return build(preorder, Integer.MAX_VALUE);
    }
    
    private TreeNode build(int[] preorder, int bound){
		
		if(index == n){
			return null;
		}
        
		if( preorder[index] > bound){
			return null;
		}
		
		int val = preorder[index++];
		TreeNode node = new TreeNode(val);
		node.left = build(preorder, val);
		node.right = build(preorder, bound);
		
		return node;
	}
}
