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
    // always go for creating a new listNode and optimise from there
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rL1 = reverse(l1);
        ListNode rL2 = reverse(l2);

        int carry =0;
        int totalSum = 0;
        ListNode dummyNode= new ListNode(); // dummy node 
        ListNode res = dummyNode;

        while( rL1 != null || rL2 != null ) {

            if( rL1 != null ){
                res.next = rL1;
            }else{
                res.next = rL2;
            }

            totalSum = 0;
            if(rL1 != null ) {
                totalSum += rL1.val;
                rL1 = rL1.next;
            }
            if(rL2 != null) {
                totalSum += rL2.val;
                rL2= rL2.next;
            }
            
            totalSum += carry;
            res.next.val = totalSum % 10;
            carry = totalSum/10;
            res = res.next;
        }
        if(carry == 1){
            res.next = new ListNode(1);
            res= res.next;
        }

        return reverse(dummyNode.next);
    }

    public ListNode reverse(ListNode curr){
        ListNode next = null; 
        ListNode prev = null;
        while( curr != null ){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    } 
}
