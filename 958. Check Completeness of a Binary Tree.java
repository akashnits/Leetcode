class Solution {
    public boolean isCompleteTree(TreeNode root) {
        return bfs(root);
    }

    boolean bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean seenNull = false;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                seenNull = true;
            } else {
                if (seenNull) {
                    // if we already saw a null before, and now a non-null node appears -> invalid
                    return false;
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return true;
    }
}
