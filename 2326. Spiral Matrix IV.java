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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        // spiral matrix traversal
        int startRow = 0;
        int startCol = 0;
        int endRow = m-1;
        int endCol = n-1;

        int[][] matrix = new int[m][n];
        ListNode curr = head;

        while(startRow <= endRow && startCol <= endCol){
            // traverse left to right
            for(int col=startCol; col <= endCol; col++){
                if(curr != null){
                    matrix[startRow][col] = curr.val;
                    curr = curr.next;
                }else{
                    matrix[startRow][col] = -1;
                }
            }

            // top to bottom
            for(int row=startRow+1; row <= endRow; row++){
                if(curr != null){
                    matrix[row][endCol] = curr.val;
                    curr = curr.next;
                }else{
                    matrix[row][endCol] = -1;
                }
            }

            // right to left
            for(int col=endCol-1; endRow > startRow && col >= startCol; col--){
                if(curr != null){
                    matrix[endRow][col] = curr.val;
                    curr = curr.next;
                }else{
                    matrix[endRow][col] = -1;
                }
            }

            // bottom to top
            for(int row =endRow-1; startCol < endCol && row > startRow; row--){
                if(curr != null){
                    matrix[row][startCol] = curr.val;
                    curr = curr.next;
                }else{
                    matrix[row][startCol] = -1;
                }
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
        return matrix;
    }
}
