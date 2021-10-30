/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Idea : Instead of using "#" for null, we can pass lower and upper bound
// and while polling from queue check if the value is in range of (lower, upper)
// if not return null

public class Codec {

    public String serialize(TreeNode root) {
         StringBuilder sb= new StringBuilder();
         serializationHelper(root, sb);
        return sb.toString();
    }
    
    private void serializationHelper(TreeNode root, StringBuilder sb){
        // added comma to identify digits (serialzed 12 can be 12 or 1,2)
        if(root == null){
            return;
        }
        
        sb.append(root.val).append(",");
        serializationHelper(root.left, sb);
        serializationHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));

        return deserializationHelper(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
     
    
    private TreeNode deserializationHelper(Queue<String> input, int lower, int upper){
        //base condition
        if(input.isEmpty()){
            return null;
        }
        String s = input.peek();
        int val = Integer.parseInt(s);
        if(val < lower || val > upper )
            return null;
        
        input.poll();
        TreeNode root = new TreeNode(val);
        root.left = deserializationHelper(input, lower, root.val);
        root.right = deserializationHelper(input, root.val, upper);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
