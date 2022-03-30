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
    int postIndex; 
    Map<Integer, Integer> valueToIndex= new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0; i < inorder.length; i++){
            valueToIndex.put(inorder[i],i);
        }
        postIndex= postorder.length -1;
        return helper(postorder, 0, postIndex, valueToIndex);
        
    }
    
    private TreeNode helper(int[] postOrder, int start, int end, Map<Integer, Integer> map){
        
        if(start > end){
            return null;
        }
        
        
        TreeNode tNode= new TreeNode(postOrder[postIndex--]);
        tNode.right= helper(postOrder, map.get(tNode.val) +1, end, map );
        tNode.left= helper(postOrder, start, map.get(tNode.val) -1, map );
        return tNode;
    }
}
