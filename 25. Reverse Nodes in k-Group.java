class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // find group of size k
        ListNode curr = head;
        int count = k;

        while ( count-- > 0 ) {
            if(curr != null)
                curr = curr.next;
            else
                return head;    // mot enough nodes
        }

        // reverse current k group
        ListNode reversedHead = reverse(head, curr);

        // join with remaiing list now 
        head.next = reverseKGroup(curr, k); 

        return reversedHead;
    }

    ListNode reverse(ListNode startNode, ListNode endNode){
        ListNode curr = startNode;
        ListNode prev = null, next = null;

        while(curr != null && curr != endNode){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }   
        return prev;
    }
}
