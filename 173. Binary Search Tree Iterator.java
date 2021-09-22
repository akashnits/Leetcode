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
class BSTIterator {
    // naive solution is to use queue 
    // this solution uses O(1) time for next() and hasNext()
    // uses O(n) memory
    Queue<Integer> queue;
    public BSTIterator(TreeNode root) {
        queue = new ArrayDeque<Integer>();
        constructQueue(root);
    }
    
    public int next() {
        return queue.poll();
    }
    
    public boolean hasNext() {
        return !queue.isEmpty();
    }
    
    public void constructQueue(TreeNode root){
        if(root == null)
            return;
        
        constructQueue(root.left);
        queue.offer(root.val);
        constructQueue(root.right);
    }
    
    
    // improvised way: 
    // next() points always points to the right subtree or parent
    // we need to have right subtree/parent to return 
    // Using stack, we can add parent while traversing the tree down
    // And whenever we pop, we can add right subtree to stack
    // doing this we would always have right/parent to return we next gets called
    
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        pushLeftNodes(root);
    }
    
    public int next() {
        TreeNode popped = stack.pop();
        pushLeftNodes(popped.right);
        return popped.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    public void pushLeftNodes(TreeNode root){
        while(root != null){
            stack.push(root);
            root= root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
