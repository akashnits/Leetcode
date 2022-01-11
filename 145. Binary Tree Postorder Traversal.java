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
    // Step1: Go all the way left and keep adding nodes to stack
    // Step2: When left is null, peek stack and decide whether to pop the node or go to it's right child
    // Step3: pop from stack and print only if right child is either null or processed ( have been visited already )
    // Step4: To decide if the node is already visited compare lastPopped node woth right child
    // Step5: If right tree is unprocessed, we move right and add node on stack
    // repeat 1 to 5 until root is not null OR stack is not empty
    
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList();
        TreeNode lastPopped = null;
        Stack<TreeNode> stack = new Stack();
        
        while(root != null || !stack.isEmpty()){
            
            // go left and add nodes
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            root = stack.peek();
            
            // we need to decide whether to pop or push right child
            if(root.right == null || root.right == lastPopped ){
                // we pop and print if right tree is either null or already processed
                lastPopped = stack.pop();
                result.add(lastPopped.val);
                root = null;
            }else{
                root = root.right;
            }
        }
        
        return result;
    }
}
