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
    public void reorderList(ListNode head) {
        if(head.next == null || head.next.next == null){
            return;
        }
        ListNode mid= findMid(head);
        ListNode right = reverse(mid.next);
        mid.next = null;
        ListNode left = head;
        merge(left, right);
        return;
    }
    
    public ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        boolean shouldPickLeft= true;
        while(left != null && right != null){
            if(shouldPickLeft){
                curr.next = left;
                left= left.next;
                shouldPickLeft = false;
            }else{
                curr.next = right;
                right= right.next;
                shouldPickLeft= true;
            }
            curr= curr.next;
        }
        curr.next = right;
        return dummy.next;
    }
    
    
    public ListNode reverse(ListNode head){
        ListNode next;
        ListNode curr= head;
        ListNode prev= null;
        
        while(curr != null){
            next= curr.next;
            curr.next = prev;
            prev= curr;
            curr= next;
        }
        return prev;
    }
    
    public ListNode findMid(ListNode head){
        ListNode slow= head;
        ListNode fast = head;
        
        ListNode prev =slow;
        while(fast != null && fast.next != null){
            prev= slow;
            slow= slow.next;
            fast= fast.next.next;
        }
        return prev;
    }
}
