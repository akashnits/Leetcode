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
    public List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return new ArrayList();
        }
        Queue<TreeNode> q = new LinkedList();

        q.add(root);
        return bfs(q);
    }


    List<Integer> bfs(Queue<TreeNode> q){
        List<Integer> res = new ArrayList();
        while(!q.isEmpty()){
            int size = q.size();
            TreeNode polled;
            int max = Integer.MIN_VALUE; // max at this level
            for(int i=0; i < size; i++){
                polled = q.poll();
                max = Math.max(max, polled.val);
                if(polled.left != null){
                    q.add(polled.left);
                }

                if(polled.right != null){
                    q.add(polled.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}
