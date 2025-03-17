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
    int maxDiff =0;
    public int maxAncestorDiff(TreeNode root) {
        solve(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        return maxDiff;
    }

    void solve(TreeNode root, int min, int max){
        if(root == null){
            return;
        }

        min = Math.min(root.val, min);
        max = Math.max(root.val, max);

        maxDiff = Math.max(Math.abs(min-max), maxDiff);

        solve(root.left, min, max);
        solve(root.right, min, max);

    }
}

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
    // traverse in post order fashion
    // find min/max for each subtree and compare with root to find maxDiff
    // compare it with root value and find maxDiff
    int maxDiff = 0;
    public int maxAncestorDiff(TreeNode root) {
        findMinAndMaxInDecendants(root);
        return maxDiff;
    }

    int[] findMinAndMaxInDecendants(TreeNode root){
        if(root == null){
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }

        // post order
        int[] leftSubTreeMinMax = findMinAndMaxInDecendants(root.left);
        int[] rightSubTreeMinMax = findMinAndMaxInDecendants(root.right);

        // compare with root val to find maxDiff
        int currMin = Math.min(leftSubTreeMinMax[0], rightSubTreeMinMax[0]);
        int currMax = Math.max(leftSubTreeMinMax[1], rightSubTreeMinMax[1]);

        
        if(currMin != Integer.MAX_VALUE){
            maxDiff = Math.max(maxDiff, Math.abs(root.val - currMin));
        } // else this node has no children

        if(currMax != Integer.MIN_VALUE){
            maxDiff = Math.max(maxDiff, Math.abs(root.val - currMax));
        }


        int newMin = Math.min(root.val, currMin);
        int newMax = Math.max(root.val, currMax);

        return new int[]{newMin, newMax};
    }
}
