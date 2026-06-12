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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<TreeNode> childNodes = new HashSet(); 
        // values to treenode
        Map<Integer, TreeNode> map = new HashMap();
        for (int[] description : descriptions) {
            int rootVal = description[0];
            int childVal = description[1];

            // get or create root node
            TreeNode rootNode = map.computeIfAbsent(rootVal, k -> new TreeNode(rootVal));

            TreeNode childNode = map.computeIfAbsent(childVal, k -> new TreeNode(childVal));

            childNodes.add(childNode); // mark it as child node

            // figure out left or right
            if (description[2] == 1) {
                rootNode.left = childNode;
            } else {
                // right
                rootNode.right = childNode;
            }
        }

        // for all nodes in the map find which isn't in set
        for(TreeNode node: map.values()){
            if(!childNodes.contains(node)){
                return node;
            }
        }

        return null;
    }
}
