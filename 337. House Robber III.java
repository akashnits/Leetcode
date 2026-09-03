class Solution {
    public int rob(TreeNode root) {
        Map<TreeNode, Map<Boolean, Integer>> dp = new HashMap<>();
        return maximumProfit(root, true, dp);
    }

    int maximumProfit(TreeNode root, boolean canRob,
                      Map<TreeNode, Map<Boolean, Integer>> dp) {

        if (root == null) return 0;

        // memoization
        if (dp.containsKey(root) && dp.get(root).containsKey(canRob)) {
            return dp.get(root).get(canRob);
        }

        int profit;

        if (canRob) {
            profit = Math.max(
                maximumProfit(root.left, true, dp) +
                maximumProfit(root.right, true, dp),

                root.val +
                maximumProfit(root.left, false, dp) +
                maximumProfit(root.right, false, dp)
            );
        } else {
            profit =
                maximumProfit(root.left, true, dp) +
                maximumProfit(root.right, true, dp);
        }

        // memoization
        dp.putIfAbsent(root, new HashMap<>());
        dp.get(root).put(canRob, profit);

        return profit;
    }
}
