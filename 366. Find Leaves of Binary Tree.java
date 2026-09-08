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

 /*
    Systematic thinking:

    - Output is roundIdx -> nodes, so label each node with its removal round.
    - Parent depends on children → use postorder.
    - For a small subtree: parent is removed one round after its last child.
    - Recurrence: round = max(leftRound, rightRound) + 1
    - Base: null = -1, so leaf gets round 0.

    Imp: in out iteration, round 1 doesn happen after round 0 - round acts as index rather
    Another way to think is - round in which a node is removed is equal to the height of the node calculated from bottom
 */
class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> findLeaves(TreeNode root) {
        res = new ArrayList();
        processInRound(root);
        return res;
    }

    int processInRound(TreeNode root){
        // base condition:
        if(root == null)
            return -1;

        // post order fashion
        int leftIdx = processInRound(root.left);
        int rightIdx = processInRound(root.right);

        int currRound = 1 + Math.max(leftIdx, rightIdx);    
        // root would be removed in curr round
        if(res.size() == currRound)
            res.add(new ArrayList());

        // add node to this round of layoffs
        res.get(currRound).add(root.val);

        return currRound;
    }
}
