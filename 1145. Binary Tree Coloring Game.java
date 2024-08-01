class Solution {
    private int leftCount = 0;
    private int rightCount = 0;

    // what if n wasn't given ?
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        // Count nodes in the tree
        countNodes(root, x, false);

        // Parent's count is the total nodes minus nodes in left, right and the node x itself
        int parentCount = countNodesParent(root, x);

        // Find the maximum number of nodes that the second player can pick
        int maxCount = Math.max(parentCount, Math.max(leftCount, rightCount));

        // The second player wins if they can control more than half of the nodes
        return maxCount > n / 2;
    }

    // early exit
    private int countNodes(TreeNode root, int x, boolean found) {
        if (root == null) {
            return 0;
        }

        if(found){
            return 0;
        }
        
        int left = countNodes(root.left, x, false);
        int right = countNodes(root.right, x, false);

        if (root.val == x) {
            leftCount = left;
            rightCount = right;
            found = true;
        }

        return left + right + 1;
    }

    private int countNodesParent(TreeNode root, int x){
        if(root == null || root.val == x){
            return 0;
        }

        return 1 + countNodesParent(root.left,x) + countNodesParent(root.right,x);
    }
}
