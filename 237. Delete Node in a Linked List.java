/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // find the last node in the lish which in non-null

        ListNode itr = node;
        while(itr != null && itr.next != null && itr.next.next != null){
            itr = itr.next;
        }

        // itr.next.next is null now
        // replace node value with itr.next value
        node.val = itr.next.val;

        // delete last node
        itr.next= null;

        // loop over the list starting at node and swap with next
        while(node != null && node.next != null){
            int temp = node.val;
            node.val = node.next.val;
            node.next.val = temp;
            node = node.next;
        }
    }
}
