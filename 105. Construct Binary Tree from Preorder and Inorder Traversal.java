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
    int index=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap();
        int n = inorder.length;
        for(int i=0 ; i < n ; i++){
            map.put(inorder[i], i);
        }
        return buildBT(preorder, 0, n-1,map);
    }
    
    private TreeNode buildBT(int[] preOrder, int start, int end, Map<Integer, Integer> map){
        if(start > end){
            return null;
        }
        
        int val = preOrder[index++];
        TreeNode node = new TreeNode(val);
        node.left = buildBT(preOrder, start, map.get(val)-1, map);
        node.right = buildBT(preOrder,  map.get(val)+1, end, map);
        
        return node;
        
    }
}
