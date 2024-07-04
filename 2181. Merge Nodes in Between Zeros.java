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
    
    public ListNode mergeNodes(ListNode head) {
        ListNode itr = head;
        ListNode dummyNode = new ListNode();

        ListNode itr1 = dummyNode;
        while(itr != null){
            if(itr.val == 0){
                // we need to merge nodes starting at itr.next
                ListNode newNode = merge(itr.next);
                // check if newNode is non-zero
                if(newNode.val != 0){
                    itr1.next = newNode;
                    itr1 = itr1.next;
                    itr = newNode;
                }else{
                    itr1.next = null;
                    break;
                }
            }
            itr = itr.next;
        }

        return dummyNode.next;
    }


    ListNode merge(ListNode head){
        ListNode itr = head;
        int sum =0;
        while(itr != null && itr.val != 0){
            sum += itr.val;
            itr = itr.next;
        }

        // create a new node with value sum
        ListNode mergedNode = new ListNode(sum);
        // we know itr.val == 0
        mergedNode.next = itr;
        return mergedNode;
    }
}
