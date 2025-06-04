class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode lPtr = dummyNode;
        while(--left > 0){
            lPtr = lPtr.next;
        }

        ListNode rPtr = dummyNode;
         while(right-- > 0){
            rPtr = rPtr.next;
        }

        ListNode sublistHead = lPtr.next; // original start of sublist
        ListNode rightList = rPtr.next;   // node after sublist

        // null-check
        if(sublistHead == null || sublistHead.next == null){
            return head;
        }

        ListNode reversedHead = reverseList(sublistHead, sublistHead.next, rightList);
        sublistHead.next = rightList;     // connect tail of reversed part to rest
        lPtr.next = reversedHead;         // connect previous part to new head

        return dummyNode.next;
    }

    // reverse from curr up to (but not including) end
    ListNode reverseList(ListNode curr, ListNode next, ListNode end) {
        if (next == end) {
            return curr;
        }
        curr.next = null;
        ListNode reversedHead = reverseList(next, next.next, end);
        next.next = curr;
        return reversedHead;
    }
}
