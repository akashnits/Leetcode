/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode curr = head;

        // First, see if there are atleast k nodes
        // k-1 edges at least
        while (count < k && curr != null) {
            curr = curr.next;
            count++;
        }

        if(count == k){
            // we can reverse list
            ListNode reversedHead = reverseLinkedList(head, curr);
            // how to link after reversal ? we need to link head ( after reversal, this would be the last node)
            // with result of reverseKGroup
            // so head.next == result of reverseKGroup
            head.next = reverseKGroup(curr, k);
            return reversedHead;

        }else{
            return head; // couldn't reverse and less than k nodes
        }
    }


    public ListNode reverseLinkedList(ListNode curr, ListNode end) {
        ListNode prev = null;

        while (curr != end) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // Return the head of the reversed list
        return prev;
    }
}
