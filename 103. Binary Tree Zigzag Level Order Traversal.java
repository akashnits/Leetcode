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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result= new ArrayList();
        if(root == null)
            return result;
        Queue<TreeNode> q= new ArrayDeque<>();
        q.add(root);
        int level=0;
        
        while(q.size() != 0){
            int size= q.size();
            List<Integer> levelList= new ArrayList(size);
            result.add(levelList);
            for(int i=0; i< size; i++){
            
                TreeNode node= q.poll();
                if(level % 2 == 1){
                    levelList.add(0, node.val); // add to the beginning of list to reverse
                }else{
                    levelList.add(node.val);
                }
            
                if(node.left != null){
                    q.add(node.left);
                }
            
                if(node.right != null){
                    q.add(node.right);
                }
            }
            level++;
        }
        
        return result;
    }
        
    
}
