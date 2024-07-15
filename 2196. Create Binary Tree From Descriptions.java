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
        // create a map for parent -> [left, right]
        Map<Integer, Integer[]> map = new HashMap();
        // create a set for children
        Set<Integer> childrenSet = new HashSet();

        for(int[] description: descriptions){
            int parentVal = description[0];
            if(map.get(parentVal) == null){
                map.put(parentVal, new Integer[2]);
            }

            Integer[] children = map.get(parentVal);
            if(description[2] == 0){
                // right child
                children[1] = description[1];
            }else{
                // left child
                children[0] = description[1];
            }
            childrenSet.add(description[1]);
        }

        int rootVal = -1;

        // loop over all children and find the node which does occur in children
        for(Map.Entry<Integer, Integer[]> entry: map.entrySet()){
            int parentVal = entry.getKey();
            if(!childrenSet.contains(parentVal)){
                rootVal = parentVal;
                break;
            }
        }

        // we now have root and map , write recursion
        return buildTree(map, rootVal);
    }


    TreeNode buildTree(Map<Integer, Integer[]> map, Integer parentVal){
        if(parentVal == null){
            return null;
        }

        TreeNode root = new TreeNode(parentVal);
        Integer[] children = map.get(parentVal);
        root.left = buildTree(map, children == null ? null: children[0]);
        root.right = buildTree(map, children == null ? null: children[1]);
        return root;
    }
}
