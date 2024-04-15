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
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }


    int dfs(TreeNode root, int num){
        if(root == null){
            return 0;
        }

        int sum =0;

        // form the number
        num = num * 10 + root.val;

        // check if leaf
        if(isLeaf(root)){
            // we have a valid number, we need to sum it
            sum += num;
        }

        sum += dfs(root.left, num) + dfs(root.right, num);

        return sum;
    }

    boolean isLeaf(TreeNode node){
        return (node.left == null & node.right == null);
    }
}
