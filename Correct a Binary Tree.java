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
    public TreeNode correctBinaryTree(TreeNode root) {
        // identify fromNode
        Queue<TreeNode> queue = new LinkedList();
        Set<Integer> set = new HashSet();
        queue.offer(root);
        set.add(root.val);
        
        // traverse
        preOrder(root, bfs(queue, set));
        return root;
    }
    
    int bfs(Queue<TreeNode> queue, Set<Integer> set){
        int res = -1;
        boolean found = false;
        while(!queue.isEmpty() && !found){
            int size = queue.size();
            
            for(int i=0; i < size; i++){
                // poll feom queue
                TreeNode polled = queue.poll();
                
                if(polled.left != null){
                    if(!set.add(polled.left.val)){
                        // couldn't add
                        res = polled.val;
                        found = true;
                    }else{
                        queue.offer(polled.left);
                    }
                }
                
                if(polled.right != null){
                    if(!set.add(polled.right.val)){
                        // couldn't add
                        res = polled.val;
                        found = true;
                    }else{
                        queue.offer(polled.right);
                    }
                }
            }
        }
        return res;
    }
    
    TreeNode preOrder(TreeNode root, int from){
        if(root == null){
            return null;
        }
        
        if(root.val == from){
            // set root to null
            root = null;
            return root;
        }
        
        root.left = preOrder(root.left, from);
        root.right = preOrder(root.right, from);
        return root;
    }
}
