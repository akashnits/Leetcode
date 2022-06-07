/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<List<Integer>> result= new ArrayList();
    List<Integer> path= new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        int sumSoFar= 0;
        helper(root, sum, sumSoFar, new ArrayList<Integer>());
        return result; 
    }
    
    private void helper(TreeNode root, int sum, int sumSoFar, List<Integer> path){
        if(root == null){
            return;
        }
        if(((sumSoFar= sumSoFar + root.val) == sum) && isLeafNode(root)){
            path.add(root.val);
            result.add(new ArrayList<Integer>(path));
            path.remove(path.size()-1);
            return;
        }
        path.add(root.val);
        helper(root.left, sum, sumSoFar, path);  
        helper(root.right, sum, sumSoFar, path);
        path.remove(path.size()-1);
        return;    
    }
    
    private boolean isLeafNode(TreeNode node){
        if(node.left == null && node.right == null){
            return true;
        }
        return false;
    }
}
