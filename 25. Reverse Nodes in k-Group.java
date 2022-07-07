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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode prev= dummy;
        ListNode curr, nxt;
        
        //pre-calculate size of list 
        
        ListNode itr = head;
        int size=0;
        while(itr != null){
            itr = itr.next;
            size++;
        }
        
        int count = size;
        
        while(count >= k){
            curr = prev.next;
            nxt = curr.next;
            
            int i =k;
            while(--i > 0){
                curr.next = nxt.next;
                nxt.next = prev.next;
                prev.next = nxt;
                nxt = curr.next;
            }
            prev = curr;
            count -= k;
        }
        
        return dummy.next;
    }
}
