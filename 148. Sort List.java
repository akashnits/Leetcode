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
    public ListNode sortList(ListNode head) {
        
        // base condition - list with one element is sorted
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode mid = findMid(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        return merge(left, right);
    }
    
    
    private ListNode merge(ListNode left, ListNode right){
        
        ListNode dummyHead= new ListNode();
        ListNode tail = dummyHead;
        while(left != null && right != null){
            // compare values and decide
            if(left.val >= right.val){
                //pick the element from right
                tail.next = right;
                right = right.next;
            }else{
                //pick the element from left
                tail.next = left;
                left = left.next;
            }
            tail= tail.next;
        }
        
        tail.next = left == null ? right : left;
        return dummyHead.next;
    }
    
    private ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next.next; // head.next can't be null
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
