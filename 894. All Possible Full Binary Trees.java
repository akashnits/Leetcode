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
    public List<TreeNode> allPossibleFBT(int n) {
        if(n % 2 == 0) {
            return new ArrayList();
        }

        return contructFBTs(0, n-1);
    }

    List<TreeNode> contructFBTs(int start, int end){
        List<TreeNode> nodeList = new ArrayList();

        if(start > end){
            nodeList.add(null);
            return nodeList;
        }

        if(start == end){
            nodeList.add(new TreeNode(0));
            return nodeList;
        }

        List<TreeNode> res = new ArrayList();

        // partition - move i from start to end
        for(int i= start; i <=end; i++){

            int leftBTSize = i-start;
            int rightBTSize = end -i;
            if( leftBTSize % 2 == 1 && rightBTSize % 2 == 1) {
                List<TreeNode> leftTree = contructFBTs(start, i-1);
                List<TreeNode> rightTree = contructFBTs(i+1, end);

                for(TreeNode leftNode: leftTree){
                    for(TreeNode rightNode: rightTree){
                        TreeNode root = new TreeNode(0);
                        root.left = leftNode;
                        root.right = rightNode;
                        res.add(root);
                    }
                }
            }
        }

        return res;
    }
}
