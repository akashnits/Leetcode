/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public Node findRoot(List<Node> tree) {
        int rootVal = 0;
        // loop over children of tree nodes and XOR
        for(Node node: tree){
            rootVal ^= node.val;
            List<Node> children = node.children;
            
            for(Node childNode: children){
                rootVal ^= childNode.val;
            }
        }

        // find the node with rootVal
        return traverse(tree, rootVal);
    }

    Node traverse(List<Node> tree, int rootVal){
        for(Node node: tree){
            if(node.val == rootVal){
                return node;
            }
        }
        return null;
    }
}
