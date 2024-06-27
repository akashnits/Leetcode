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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inOrder = inOrderTraversal(root, new ArrayList());

        // construct a BST from preOrder and inOrder traversal
        return constructBST(inOrder, 0, inOrder.size()-1);
    }

    TreeNode constructBST(List<Integer> inOrder, int left, int right){
        if(left > right){
            return null;
        }

        // mid should be the head
        int mid = left + (right - left)/2;

        TreeNode root = new TreeNode(inOrder.get(mid));
        root.left = constructBST(inOrder, left, mid-1);
        root.right = constructBST(inOrder, mid +1, right);
        return root;    
    }


    List<Integer> inOrderTraversal(TreeNode root, List<Integer> inOrderList){
        if(root == null){
            return null;
        }

        inOrderTraversal(root.left, inOrderList);
        inOrderList.add(root.val);
        inOrderTraversal(root.right, inOrderList);
        return inOrderList;
    }
}
