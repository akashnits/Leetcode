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
    public List<Double> averageOfLevels(TreeNode root) {
        // do a bfs and calculate average
        
        return bfs(root, new ArrayList());
    }
    
    
    private List<Double> bfs(TreeNode root, List<Double> result){
        
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        q.offer(root);
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            double sum= 0.0;
            for(int i= 0; i < size; i++){
                // poll and add children to queue
                TreeNode polled = (TreeNode) q.poll();
                sum += polled.val;
                
                if(polled.left != null){
                    q.offer(polled.left);
                }
                
                if(polled.right != null){
                    q.offer(polled.right);
                }
            }
            double average = sum / size;
            result.add(average);
        }
        
        return result;
    }
}
