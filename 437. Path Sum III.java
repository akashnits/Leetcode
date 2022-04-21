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
    // map containing sum as key and it's freq as value
    // count = count+ map.get(sum[i]-k);
   
    public int pathSum(TreeNode root, int targetSum) {
        
       Map<Integer, Integer> map = new HashMap();
       map.put(0,1);  
       return calculatePaths(root, targetSum, 0, map); 
    }
    
    private int calculatePaths(TreeNode root, int k, int sum, Map<Integer, Integer> map){
        if(root == null){
            return 0;
        }
        
        sum +=  root.val;
        // initialize count checking if it's equals targetSum
        int count = map.getOrDefault(sum-k, 0);
        
        // increase freq of sum
        map.put(sum, map.getOrDefault(sum, 0) +1);
        
        count += calculatePaths(root.left, k, sum, map)+
        calculatePaths(root.right, k, sum, map);
        // restore map 
        map.put(sum, map.get(sum) -1);
        return count;
    }
    
}
