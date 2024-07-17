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
    List<TreeNode> res;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        res = new ArrayList();

        Set<Integer> set = new HashSet();
        for(int d: to_delete){
            set.add(d);
        }
        findAndDelete(root, set);
        if(!set.contains(root.val)){
            res.add(root);
        } 
        return res;
    }

    TreeNode findAndDelete(TreeNode root, Set<Integer> set){
        if(root == null){
            return null;
        }

        root.left = findAndDelete(root.left, set);
        root.right = findAndDelete(root.right, set);
        // we have found a node to delete
        if(set.contains(root.val)){
            // no children, 1 children, 2 children
            if(root.left == null && root.right == null){
                // case 1: no children, leaf node - set to null
                return null;
            }else {
                // case 2: have at least one child
                TreeNode leftChild = root.left;
                TreeNode rightChild = root.right;
                
                if(leftChild != null){
                    res.add(leftChild);
                }
                if(rightChild != null){
                    res.add(rightChild);
                }
                return null;
            }
        }else{
            return root;
        }
    }
}
