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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // try flipping 
        return makeFlips(root1, root2);
    }

    private boolean makeFlips(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }

        if(root1 == null && root2 != null || root1 != null && root2 == null){
            return false;
        }

        // this shoule be equal as we must have flipped if it wasn't equal
        if(root1.val != root2.val){
            return false;
        }

        // case1: no need to flip
        // case 2: we need a flip for sure
            return makeFlips(root1.left, root2.left) && makeFlips(root1.right, root2.right) 
                || makeFlips(root1.right, root2.left) && makeFlips(root1.left, root2.right);
        
    }
}
