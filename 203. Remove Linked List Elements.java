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
    public ListNode removeElements(ListNode head, int val) {
        // no element
        if(head == null)
            return head;
        
        ListNode curr = head;
        
        while(curr != null){
            while( curr.next != null && curr.next.val == val ){
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        
        if(head != null && head.val == val){
            return head.next;
        }else{
            return head;
        }
    }
}
