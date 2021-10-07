/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    //Idea: To use binary search in linkedList,
    // 1. make use of slow, fast pointers
    // 2. Boundaries would be head and tail ( same way it's start, end for an array)
    public TreeNode sortedListToBST(ListNode head) {
        return constructBSTs(head, null);
    }
   
    TreeNode constructBSTs(ListNode head, ListNode tail){
        if(head == null){
            return null;
        }
       
        if(head == tail)
            return null;
       
        ListNode slow = head;
        ListNode fast = head;
       
        //find mid of list
        while(fast != tail && fast.next != tail){
            slow= slow.next;
            fast = fast.next.next;
        }
       
        //slow pointer is at mid now
        TreeNode root= new TreeNode(slow.val);
        root.left= constructBSTs(head, slow);
        root.right = constructBSTs(slow.next, tail);
       
        return root;
       
    }
}
