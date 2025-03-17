class Solution {
    int MOD = 1000000007;
    long maxDiff = 0;
    int totalSum = 0;

    public int maxProduct(TreeNode root) {
        totalSum = calculateTotalSum(root);
        sumNodes(root);
        return (int)(maxDiff % MOD);
    }

    int calculateTotalSum(TreeNode root){
        if(root == null){
            return 0;
        }
        return root.val + calculateTotalSum(root.left) + calculateTotalSum(root.right);
    }

    int sumNodes(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftSubTreeSum = sumNodes(root.left);
        int rightSubTreeSum = sumNodes(root.right);
        int subTreeSum = root.val + leftSubTreeSum + rightSubTreeSum;

        // Perform multiplication in long to avoid overflow
        long product = 1L * subTreeSum * (totalSum - subTreeSum);
        maxDiff = Math.max(maxDiff, product);

        return subTreeSum;
    }
}
