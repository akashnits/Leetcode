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
        ListNode[] ans = new ListNode[k];

        ListNode itr = head;
        int n= 0;
        while(itr != null){
            n++;
            itr = itr.next;
        }

        int extraItems = n % k;

        ListNode curr = head;
        for(int part=0; part < k; part++){
            // for each part, create a ListNode chain of size partitionLength + 1 ( if we have extraItems)
            int partitionLength = n/k + (extraItems-- > 0 ? 1: 0);
            // loop for partition length and create a chain
            if(curr == null) break;
            ListNode prev = new ListNode(curr.val, null);
            ans[part] = prev;
            for(int i=1; i< partitionLength; i++){
                curr = curr.next;
                if(curr == null) break;
                ListNode currNode = new ListNode(curr.val, null);
                prev.next = currNode;
                prev = currNode;
            }
            if(curr != null) curr= curr.next;
        }

        return ans;
    }
}
