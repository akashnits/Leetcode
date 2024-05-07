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
    public ListNode doubleIt(ListNode head) {
        ListNode reversed = reverse(head, null);

        // loop over this list and double each digit
        int carry =0;

        ListNode itr = reversed;
        ListNode prev = null;
        while(itr != null){
            int doubled = (itr.val * 2) + carry;
            int newVal = doubled % 10;
            carry = doubled / 10;

            // assign new value 
            itr.val = newVal;
            prev = itr;
            itr = itr.next;
        }

        // check if have carry ?
        if(carry > 0){
            // insert a new node
            ListNode newNode = new ListNode(1);
            prev.next = newNode;
        }

        return reverse(reversed, null);
    }


    ListNode reverse(ListNode curr, ListNode prev){
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
