/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Idea: Serialising a binary tree means
// adding the root value , then left and right serailizations
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializationHelper(root, "");
    }
    
    private String serializationHelper(TreeNode root, String s){
        // added comma to identify digits (serialzed 12 can be 12 or 1,2)
        // represented null with $ sign
        if(root == null){
            return "$,";
        }
        
        return s + root.val + "," + serializationHelper(root.left, s) + serializationHelper(root.right, s);
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));

        return deserializationHelper(queue);
    }
     
    int position =0;
    
    private TreeNode deserializationHelper(Queue<String> input){
        //base condition
        
        String s = input.poll();
        if (s.equals("$")) return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = deserializationHelper(input);
        root.right = deserializationHelper(input);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
