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
    int res = 0;
    public int averageOfSubtree(TreeNode root) {
        calculateSumWithNodeCount(root);
        return res;
    }


    int[] calculateSumWithNodeCount(TreeNode root){
        if(root == null){
            return new int[]{0, 0};
        }

        int[] left = calculateSumWithNodeCount(root.left);
        int[] right = calculateSumWithNodeCount(root.right);

        int sum = left[0] + right[0] + root.val;
        int nodeCount = left[1] + right[1] + 1;

        int avg = sum / nodeCount;
        if(avg == root.val){
            res++;
        }

        return new int[]{sum, nodeCount} ;
    }
}
