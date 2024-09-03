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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;

        ListNode slow = dummyNode;
        ListNode fast = dummyNode;

        while(k-- > 0){
            slow = slow.next;
        }

        ListNode kth = slow;

        while(slow != null){
            fast = fast.next;
            slow = slow.next;
        }

        int temp = kth.val;
        kth.val = fast.val;
        fast.val = temp;

        return dummyNode.next;
    }
}
