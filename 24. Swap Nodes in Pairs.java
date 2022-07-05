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
class Solution {
    public ListNode swapPairs(ListNode head) {
        
        if(head == null || head.next == null){
            // list smaller than length 2, return 
            return head;
        }
        
        ListNode dummyNode = new ListNode();
        
        
        ListNode prev = dummyNode;
        ListNode curr= head;
        
        while( curr != null && curr.next != null ){
            prev.next = curr.next;
            curr.next = prev.next.next;
            prev.next.next = curr;
            
            prev = curr;
            curr = curr.next;
        }
        
        return dummyNode.next;
    }
}
