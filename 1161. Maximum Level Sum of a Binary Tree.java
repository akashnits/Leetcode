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
    public int maxLevelSum(TreeNode root) {
        return bfs(root);
    }


    public int bfs(TreeNode root){
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        int level = 0, res = 1;
        int maxSum = Integer.MIN_VALUE, levelSum =0;

        while(!queue.isEmpty()){
            level++;
            int nodesSize = queue.size();
            levelSum=0;
            for(int i=0; i < nodesSize; i++){
                TreeNode node = queue.poll();
                levelSum += node.val;
                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){
                    queue.add(node.right);
                }
            }
            if(levelSum > maxSum){
                maxSum = levelSum;
                res= level;
            }
        }

        return res;
    }
}
