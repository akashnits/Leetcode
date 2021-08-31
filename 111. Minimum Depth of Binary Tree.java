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
    // using dfs 
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        
        int ld= minDepth(root.left);
        int rd= minDepth(root.right);
        
      // we can't take left or right subtree of height 0 it indicates that tree doesn't exist
        if(ld == 0){
            return 1 + rd;
        }else if(rd == 0){
            return 1 + ld;
        }else{
            return 1 + Math.min(ld, rd);
        }
    } 
    
    //using bfs
    public int minDepth(TreeNode root) {
        int level = 0;
        if(root == null){
            return 0;
        }
        
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        q.offer(root);
        ++level;
        
        while(!q.isEmpty()){
            int count = q.size();
            
            for(int i = 0; i < count; i++){
                
                TreeNode polled = q.poll();
                
                if(isLeaf(polled)){
                    return level;
                }
                
                if(polled.left != null){
                    q.offer(polled.left);
                }
                
                if(polled.right != null){
                    q.offer(polled.right);
                }
            }
            ++level;
        }
        return level;
    }
    
    public boolean isLeaf(TreeNode root){
     return root.left == null && root.right == null;   
    }
}
