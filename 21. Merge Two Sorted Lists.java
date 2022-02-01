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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode();
        ListNode itr = dummyNode;
        
        while(list1 != null && list2 != null){
            if(list1.val >= list2.val){
                itr.next = list2;
                ListNode prev = list2;
                list2 = list2.next;
                prev.next = null;
            }else{
                itr.next = list1;
                ListNode prev = list1;
                list1 = list1.next;
                prev.next = null;
            }
            itr = itr.next;
        }
        
        itr.next = list1 == null ? list2: list1;
        return dummyNode.next;
    }
}
