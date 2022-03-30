class Solution {
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        
        
        flatten(root.left);
        //check if node have left child, if not, we don't need to flatten
        if(root.left != null){
            
            //detach right child and store in temp
            TreeNode temp = root.right;
            
            //attach left child to right of root and make left child null
            root.right = root.left;
            root.left= null;
            
            //attach node stored in temp at the bottom-right of new right child
            TreeNode node = root;
            while(node.right != null){
                node = node.right;
            }
            
            node.right = temp;
        }
        flatten(root.right);
        
    }
}
