class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        collectLeaves(root1, sb1);
        collectLeaves(root2, sb2);
        
        return sb1.toString().equals(sb2.toString());
    }
    
    private void collectLeaves(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        
        if (root.left == null && root.right == null) {
            sb.append(root.val).append(":");
            return;
        }
        
        collectLeaves(root.left, sb);
        collectLeaves(root.right, sb);
    }
}
