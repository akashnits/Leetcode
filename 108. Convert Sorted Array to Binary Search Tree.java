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
    // for tree to be height balanced select mid index as root of tree
    public TreeNode sortedArrayToBST(int[] nums) {
        return constructBST(nums, 0, nums.length-1);
    }
    
    
    TreeNode constructBST(int[] nums, int l, int r){
        //base condition
        if(l > r){
            return null;
        }
        
        int mid = l + (r-l)/2;
        
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructBST(nums, l, mid-1);
        root.right = constructBST(nums, mid+1, r);
        
        return root;
    }
}
