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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode itr = head;
        int size = 0;

        while(itr != null){
            itr = itr.next;
            size++;
        }

        
        if(size == k){
            // all list of size 1
            return partition(head, k, 1 , 0);
        }else if(k > size){
            // all lists of size 1 or 0
            // k - size nodes would be null
            return partition(head, k, 1, 0);
        }else{
            // list size would be n /k
            // n % k would be extra nodes to accomodate
            return partition(head, k, size / k , size % k);
        }
    }

    ListNode[] partition(ListNode head, int k, int size, int extraNodes){
        ListNode[] res = new ListNode[k];
        ListNode dummyNode = new ListNode();
        ListNode curr = dummyNode;
        curr.next = head;

        int count = 0;
        int idx = 0;
        while(count < k && curr != null){
            res[idx++] = curr.next;
            curr.next = null;
            curr = res[idx-1];
            int subLen = size-1; // we have already added head to sublist
            while(subLen-- > 0 && curr != null){
                curr= curr.next;
            }
            // check if we have extra nodes to accomodate
            if(extraNodes > 0 && curr != null){
                curr = curr.next;
                extraNodes--;
            }
            count++;
        }
        return res;
    }
}
