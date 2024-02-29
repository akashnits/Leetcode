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
    public boolean isEvenOddTree(TreeNode root) {
        return bfs(root);
    }

    boolean bfs(TreeNode root){
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        int level =0;
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean isLevelEven = (level%2 == 0);
            int prev = isLevelEven ? Integer.MIN_VALUE:Integer.MAX_VALUE;
            for(int i=0; i < size; i++){
                TreeNode polled = queue.poll();

                if(isLevelEven){
                    // must be odd value
                    // must be strictly increasing
                    if(polled.val <= prev || polled.val%2 == 0){
                        return false;
                    }
                }else{
                    // must be even
                    // must be strcitly decreaing
                    if(polled.val >= prev || polled.val%2 == 1){
                        return false;
                    }
                }

                if(polled.left != null){
                    queue.offer(polled.left);
                }

                if(polled.right != null){
                    queue.offer(polled.right);
                }

                prev = polled.val;
            }
            level++;
        }
        return true;
    }
}
