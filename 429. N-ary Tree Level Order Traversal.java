/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList();
        Queue<Node> q = new LinkedList<Node>();
        
        if(root == null){
            return result;
        }
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> levelList = new ArrayList();
            for(int i=0; i < size; i++){
                Node polled = q.poll();
                levelList.add(polled.val);
                
                // add it's children to the queue
                for(Node childNode: polled.children){
                    q.offer(childNode);
                }
            }
            result.add(levelList);
        }
        
        return result;
    }
}
