class Solution {
    // Approach: 
    // use postoder to figure out left and right subtree
    // iterate in pre-order fashion
    // next node is either leftChild or rightChild if leftChild is null
    // we assume that leftChild is present (hint: multiple ans exists )
    // exclude root from right subtree and it's already processed

    int idx = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        // Map each value in postorder to its index for quick lookup
        Map<Integer, Integer> postIndexMap = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            postIndexMap.put(postorder[i], i);
        }

        // Start recursive construction
        return build(preorder, postorder, 0, postorder.length - 1, postIndexMap);
    }

    private TreeNode build(int[] preorder, int[] postorder, int l, int r, Map<Integer, Integer> postIndexMap) {
        // Base case: no elements in this subtree
        if (idx >= preorder.length || l > r) return null;

        // leaf node
        if(l == r || idx ==  preorder.length-1) return new TreeNode(preorder[idx++]);

        // Create root from current preorder index
        TreeNode root = new TreeNode(preorder[idx++]);

        // Next preorder element is the left child; find its index in postorder
        int mid = postIndexMap.get(preorder[idx]);

        // Recursively build left and right subtrees
        root.left = build(preorder, postorder, l, mid, postIndexMap);
        root.right = build(preorder, postorder, mid + 1, r - 1, postIndexMap); // Exclude root at r

        return root;
    }
}
