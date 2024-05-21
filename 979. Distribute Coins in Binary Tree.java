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
    // Approach: Idea is to keep just one coin with each node, pass rest to the other nodes
    // how to pass coins from child to parent ?
    // post order traversal
    int moves = 0;
    public int distributeCoins(TreeNode root) {
        passExtraCoins(root);
        return moves;
    }

    int passExtraCoins(TreeNode root){
        if(root == null){
            return 0;
        }

        // extra coins from left
        int extraCoinsFromLeftTree = passExtraCoins(root.left);
        // extra coins from right
        int extraCoinsFromRightTree = passExtraCoins(root.right);

        // total extra coins - it would keep 1 coins and transfer rest
        int extraCoins = extraCoinsFromLeftTree + extraCoinsFromRightTree + root.val -1;

        // to transfer n coins by 1 step, it takes n moves
        // when extraCoins is negative - need to pass from parent to child - make a move
        // when extraCoins is positive - need to pass from child to parent - make a move
        moves += Math.abs(extraCoins); // move all extra coins to neighbor ( neighbor is 1 unit away )
        
        return extraCoins;
    }
}
