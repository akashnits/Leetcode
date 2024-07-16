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
    Map<Integer, List<Pair<Integer, Character>>> graph;
    String res = "";
    public String getDirections(TreeNode root, int startValue, int destValue) {
        // create a graph from give tree
        graph = new HashMap();
        buildGraph(root, null, null);
        // dfs from source keeping tracking of direction
        int n = graph.size();

        dfs(startValue, destValue, new ArrayList(), new boolean[n+1]);
        return res;
    }

    void dfs(int currValue, int destValue, List<Character> path, boolean[] visited){
        if(currValue == destValue){
            // we have reached destination
            res = new String(path.stream().map(String::valueOf).collect(Collectors.joining()));
            return;
        }

        // mark visited
        visited[currValue] = true;

        // go to all neighbors
        for(Pair<Integer, Character> neighbor: graph.get(currValue)){
            int neighborValue = neighbor.getKey();
            Character dir = neighbor.getValue();
            if(!visited[neighborValue]){
                path.add(dir);
                dfs(neighborValue, destValue, path, visited);
                path.remove(path.size() -1);
            }
        }

    }


    void buildGraph(TreeNode root, TreeNode parent, Boolean isLeftChild){
        if(root == null){
            // can't add edge
            return;
        }

        // build graph by traversing in in-order fashion
        buildGraph(root.left, root, true);
        // add edge

        // u -> v, v -> u
        // child to parent edge if parent is not null
        if(parent != null){
            graph.putIfAbsent(root.val, new ArrayList<>());
            graph.get(root.val).add(new Pair<>(parent.val, 'U'));
        }
        // parent to child edge if parent is not null
        if(parent != null && isLeftChild != null){
            graph.putIfAbsent(parent.val, new ArrayList<>());
            graph.get(parent.val).add(new Pair<>(root.val, isLeftChild ? 'L' : 'R'));
        }

        buildGraph(root.right, root, false);
    }
}
