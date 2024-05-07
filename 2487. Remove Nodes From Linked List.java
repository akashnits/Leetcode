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
    public ListNode removeNodes(ListNode head) {
        ListNode reversed = reverse(head, null);

        // loop through reversed list and remove nodes 
        ListNode curr = reversed;
        ListNode nextNode = null;
        ListNode prev= null;

        while(curr != null){
            nextNode = curr.next;
            while(nextNode != null && curr.val > nextNode.val){
                // skip this node
                nextNode = nextNode.next;
            }
            curr.next = nextNode; // create a link after skipping
            curr = nextNode;
        }
        // reverse the list again
        return reverse(reversed, null);
    }

    ListNode reverse(ListNode curr, ListNode prev){
        ListNode next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr= next;
        }
        return prev;
    }
}
