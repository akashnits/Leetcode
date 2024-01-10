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
    Map<Integer, List<Integer>> graph;
    int res =0;
    public int amountOfTime(TreeNode root, int start) {
        // create a graph by iterating through the tree
        graph = new HashMap();

        inOrderTraversal(root, null);
        
        dfs(start, new HashSet(), 0);

        return res;
    }

    void dfs(int start, Set<Integer> visited, int dist){
        // mark visited
        visited.add(start);
        res = Math.max(res, dist);

        if(graph.get(start) == null) return;
        // go to all it's neighbors and do dfs if not already visited
        for(int neighbor: graph.get(start)){
            if(!visited.contains(neighbor)){
                dfs(neighbor, visited, dist+1);
            }
        }
    }

    void inOrderTraversal(TreeNode root, TreeNode parent){
        if(root == null){
            return;
        }

        inOrderTraversal(root.left, root);

        // add edge in graph : parent -> root and root -> parent
        // check parent isn't null
        if(parent != null){
            if(!graph.containsKey(root.val)){
                graph.put(root.val, new ArrayList());
            }
            if(!graph.containsKey(parent.val)){
                graph.put(parent.val, new ArrayList());
            }

            graph.get(root.val).add(parent.val);
            graph.get(parent.val).add(root.val);
        }
        
        inOrderTraversal(root.right, root);
    }
}
