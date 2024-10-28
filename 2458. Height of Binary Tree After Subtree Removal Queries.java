class Solution {
    // Approach: Idea is to keep track of height of tree before each node was added
    // height would be the length of the largest path we have seen so far
    // while traversing from left to right or right to left
    
    // Array to store the maximum height of the tree after removing each node
    static final int[] maxHeightAfterRemoval = new int[100001];

    // this variable keeps track of maxHeight we have seen so far
    // while traversing from left to right, for the right subtree we consider max height from left subtree
    // while traversing from right to left, for the left subtree, we consider max height from right subtree
    int currentMaxHeight = 0; 

    public int[] treeQueries(TreeNode root, int[] queries) {
        // left to right traversal
        traverseLeftToRight(root, 0);
        currentMaxHeight = 0; // Reset for the second traversal
        // right to left traversal
        traverseRightToLeft(root, 0);

        // Process queries and build the result array
        int queryCount = queries.length;
        int[] queryResults = new int[queryCount];
        for (int i = 0; i < queryCount; i++) {
            queryResults[i] = maxHeightAfterRemoval[queries[i]];
        }

        return queryResults;
    }

    private void traverseLeftToRight(TreeNode node, int currentHeight) {
        if (node == null) return;

        // Store the maximum height if this node were removed
        maxHeightAfterRemoval[node.val] = currentMaxHeight;

        // update with max height we have seen so far
        currentMaxHeight = Math.max(currentMaxHeight, currentHeight);

        // Traverse left subtree first, then right
        traverseLeftToRight(node.left, currentHeight + 1);
        traverseLeftToRight(node.right, currentHeight + 1);
    }

    private void traverseRightToLeft(TreeNode node, int currentHeight) {
        if (node == null) return;

        // Update the maximum height if this node were removed
        maxHeightAfterRemoval[node.val] = Math.max(
            maxHeightAfterRemoval[node.val],
            currentMaxHeight
        );

        // Update the current maximum height
        currentMaxHeight = Math.max(currentHeight, currentMaxHeight);

        // Traverse right subtree first, then left
        traverseRightToLeft(node.right, currentHeight + 1);
        traverseRightToLeft(node.left, currentHeight + 1);
    }
}
