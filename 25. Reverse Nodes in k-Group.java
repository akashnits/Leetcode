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
        // base conditions:
        if(k == 1){
            return head;
        }

        if(head == null || head.next == null){
            return head;
        }

        if(size(head) < k){
            return head;
        }

        ListNode curr = head;
        // advance by k-1 times
        int i = k-1;
        while(i-- > 0){
            curr = curr.next;
        }
        // break list into parts: list of size k and rest of the list
        ListNode reversedKGroupNode = reverseKGroup(curr.next, k);
        curr.next = null;
        ListNode reversedNode = reverseList(head, head.next);
            
        // combine above lists after reversal
        head.next = reversedKGroupNode;
        return reversedNode;
    }

    ListNode reverseList(ListNode curr, ListNode next){
        if(next == null){
            return curr;
        }

        // break lists into two parts
        ListNode reversedHead = reverseList(next, next.next);

        // combine them
        next.next = curr;
        curr.next= null;
        return reversedHead;
    }

    int size(ListNode head){
        int count = 0;
        while(head != null){
            head = head.next;
            count++;
        }
        return count;
    }
}
