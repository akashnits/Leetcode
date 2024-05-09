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
    public ListNode rotateRight(ListNode head, int k) {
        int n =0;
        ListNode itr = head;
        ListNode lastNode = null;
        while(itr != null){
            n++;
            lastNode = itr;
            itr = itr.next;

        }

        if(n < 2){
            return head;
        }
        int normalizedK = k % n;
        int rotateByK = n - normalizedK;
        if(rotateByK == n){
            return head;
        }
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;

        ListNode curr = dummyNode;
        // move head by rotateByK values
        while(rotateByK > 0){
            curr = curr.next;
            rotateByK--;
        }

        // save the new head
        dummyNode.next = curr.next;
        curr.next = null;

        // point last node to original head
        lastNode.next = head;

        return dummyNode.next;
    }
}
