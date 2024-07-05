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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> criticalPoints = new ArrayList();

        ListNode curr = head;
        ListNode prev = null, next = null;

        int currIdx = 0;
        while(curr != null){
            next = curr.next;

            // check if curr is critical node
            if(prev != null && next != null){ // first or last node can't be critical 
                // check if local maxima or minima
                if(prev.val > curr.val && next.val > curr.val){
                    // local minima
                    criticalPoints.add(currIdx);
                }else if(prev.val < curr.val && next.val < curr.val){
                    // local maxima
                    criticalPoints.add(currIdx);
                }
            }

            // update pointers
            prev = curr;
            curr = next;
            currIdx++;
        }

        if(criticalPoints.size() < 2){
            return new int[]{-1, -1};
        }

        // we now have info about critical points, find min/max distance
        int minDistance = Integer.MAX_VALUE;
        int maxDistance = Integer.MIN_VALUE;

        int n = criticalPoints.size();
        maxDistance = criticalPoints.get(n-1) - criticalPoints.get(0);

        for(int i=0; i < n-1; i++){
            minDistance = Math.min(minDistance, criticalPoints.get(i+1) - criticalPoints.get(i));
        }
        return new int[]{minDistance, maxDistance};
    }
}
