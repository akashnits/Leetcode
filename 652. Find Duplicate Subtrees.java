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
//Idea is to use serialization as hash key
class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
         List<TreeNode> result = new LinkedList();
         findDuplicateHelper(root, new HashMap<String, Integer>(), result);
         return result;
    }
    
    
    private String findDuplicateHelper(TreeNode root, Map<String, Integer> map, List<TreeNode> result){
        //base condition
        if(root == null)
            return "#";
        
        String serialized = root.val + "," + findDuplicateHelper(root.left, map, result) + "," + findDuplicateHelper(root.right, map, result);
        
        int count = map.getOrDefault(serialized, 0);
        if( count == 1){
            //found a duplicate, add to result
            result.add(root);
        }
        map.put(serialized, count+1);
        
        return serialized;
    }
}
