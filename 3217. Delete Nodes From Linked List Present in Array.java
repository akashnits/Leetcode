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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet();

        for(int num: nums){
            set.add(num);
        }

        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        
        ListNode curr = dummyNode;

        ListNode next = curr.next;
        while(curr != null){
            next = curr.next;
            if(next != null && set.contains(next.val)){
                curr.next = next.next;
            }else{
                curr = curr.next;
            }
        }

        return dummyNode.next;
    }
}
