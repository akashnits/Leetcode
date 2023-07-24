class Solution {
    public int rob(TreeNode root) {
        Map<TreeNodeWithBoolean, Integer> dp = new HashMap();
        return maximumProfit(root, true, dp);
    }


    int maximumProfit(TreeNode root, boolean canRob, Map<TreeNodeWithBoolean, Integer> dp){

        if(root == null) return 0;

        TreeNodeWithBoolean key = new TreeNodeWithBoolean(root, canRob);
        if(dp.containsKey(key)){
            return dp.get(key);
        }

        if(canRob){
            // it may or may not rob
            dp.put(key, Math.max((maximumProfit(root.left, true, dp) + maximumProfit(root.right, true, dp)),
                           (root.val + maximumProfit(root.left, false, dp) + maximumProfit(root.right, false, dp))));
            return dp.get(key);               
        }else{
            // it must not rob
            dp.put(key, maximumProfit(root.left, true, dp) + maximumProfit(root.right, true, dp));
            return dp.get(key);
        }

    }

    public class TreeNodeWithBoolean {
        public TreeNode treeNode;
        public boolean canRob;

        public TreeNodeWithBoolean(TreeNode treeNode, boolean canRob) {
            this.treeNode = treeNode;
            this.canRob = canRob;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNodeWithBoolean that = (TreeNodeWithBoolean) o;
            return canRob == that.canRob && Objects.equals(treeNode, that.treeNode);
        }

        @Override
        public int hashCode() {
            return Objects.hash(treeNode, canRob);
        }
    }

}
