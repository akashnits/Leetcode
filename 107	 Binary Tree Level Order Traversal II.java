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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList();
        
        if(root == null){
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            
            int count = queue.size(); //gives count of elements present at that level
            List<Integer> levelList = new ArrayList();
            
            for(int i=0; i < count; i++){
                TreeNode polled = queue.poll();
                
                //add it to level list and it's children to queue
                levelList.add(polled.val);
                
                if(polled.left != null){
                    queue.offer(polled.left);
                }
                
                 if(polled.right != null){
                    queue.offer(polled.right);
                }
            }
            result.add(0,levelList);
        }
        
        return result;
        
    }
}
