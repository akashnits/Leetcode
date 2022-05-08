/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

public class Solution {
   
    Node[] visited;
    
    public Node cloneGraph(Node node) {
        visited = new Node[102];
        return clone(node);
    }

    private Node clone(Node node) {
        if (node == null) return null;
        
        if (visited[node.val] != null) {
            return visited[node.val];
        }
        Node copy = new Node(node.val);
        //mark visited
        visited[node.val] = copy;
        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(clone(neighbor));
        }
        return copy;
    }
}
