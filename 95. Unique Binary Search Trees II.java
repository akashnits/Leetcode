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
    List<TreeNode> result = new ArrayList();
    public List<TreeNode> generateTrees(int n) {
        return constructBSTs(1, n);
    }
    
    
    public List<TreeNode> constructBSTs(int start, int end){
        List<TreeNode> list = new ArrayList<TreeNode>();

        if(start > end){
            list.add(null);
            return list;
        }
        
         if(start == end){
            list.add(new TreeNode(start));
            return list;
        }
        
        List<TreeNode> left, right;
        for(int i=start; i<=end ; i++){
            //each i as root val
            left = constructBSTs(start, i-1);
            right = constructBSTs(i+1, end);
            for(TreeNode l : left){
                for(TreeNode r: right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
