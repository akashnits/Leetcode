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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        
        ListNode l = dummy;
        while( --left > 0 ){
            l = l.next;
        }
        
        ListNode r = head;
        while( --right > 0){
            r= r.next;
        }
        
        ListNode join= r.next;
        r.next = null;
        
        l.next = reverse(l.next, join);
        return dummy.next;
            
    }
    
    
    ListNode reverse(ListNode head, ListNode join){
        ListNode prev=null, curr= head, next;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = join;
        return prev;
    }
}
