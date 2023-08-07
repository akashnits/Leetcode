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
    public List<TreeNode> generateTrees(int n) {
        return constructBSTs(0, n-1);
    }


    List<TreeNode> constructBSTs(int start, int end){
        List<TreeNode> nodeList =  new ArrayList();
        // base condition
        if(start > end){
            nodeList.add(null);
            return nodeList;
        }

        // only one node
        if(start == end){
            TreeNode node = new TreeNode(start+1);
            nodeList.add(node);
            return nodeList;
        }

        List<TreeNode> res = new ArrayList();

        // choices- make each ele root 
        for(int i= start; i <= end; i++){
            // we can construct left BSTs with nodes which is left of i -> List<TreeNode>
            // we can contruct right BSTs with nodes which is right of i -> List<TreeNode>
            List<TreeNode> leftBSTs = constructBSTs(start, i-1);
            List<TreeNode> rightBSTs = constructBSTs(i+1, end);

            // say left BSTs = B1, B2, B3
            // right BSTs = B4, B5
            // we can have a tree as [B1, root, B4], [B2, root, B4], so on....
            for(TreeNode leftNode: leftBSTs){
                for(TreeNode rightNode: rightBSTs){
                    // we permute all leftBST with rightBSTs
                    TreeNode root = new TreeNode(i+1);
                    root.left = leftNode;
                    root.right = rightNode;
                    res.add(root);
                }
            }
        }

        return res;
    }
}
