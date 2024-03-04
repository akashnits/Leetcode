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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        while(n-- > 0){
            fast = fast.next;
        }

        ListNode dummyNode = new ListNode();
        ListNode prev= dummyNode;
        prev.next = head;

        while(fast != null){
            prev = slow;
            fast = fast.next;
            slow = slow.next;
        }

        // delete the slow node 
        prev.next = slow.next;
        

        return dummyNode.next;
    }
}
