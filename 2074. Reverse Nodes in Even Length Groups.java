class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        return reverseGroups(head, 1);
    }

    ListNode reverseGroups(ListNode head, int groupNumber) {
        // Base condition to stop recursion
        if (head == null) {
            return null;
        }

        // Find the nodes in the current group
        ListNode curr = head;
        int count = 0;
        while (count < groupNumber && curr != null) {
            curr = curr.next;
            count++;
        }

        int groupSize = (count == groupNumber) ? groupNumber : count;

        // If groupSize is even, reverse the group
        if (groupSize % 2 == 0) {
            // Reverse the group
            ListNode reversedHead = reverseKNodes(head, groupSize);

            // Now, `head` is the last node of the reversed group
            // So, connect it to the result of the next group
            head.next = reverseGroups(curr, groupNumber + 1);

            // Return the new head after reversing the group
            return reversedHead;
        } else {
            // If groupSize is odd, don't reverse the group
            ListNode tail = head;
            for (int i = 1; i < count; i++) {
                tail = tail.next;
            }
            tail.next = reverseGroups(curr, groupSize + 1);
            return head;
        }
    }

    // Helper function to reverse the first `k` nodes
    ListNode reverseKNodes(ListNode curr, int k) {
        ListNode prev = null;
        while (k-- > 0 && curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}
