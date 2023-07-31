class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // fixed size sliding window

        int start =0;
        int end =0;

        int n = nums.length;
        int[] res = new int[n-k+1];

        ArrayDeque<Integer> deque = new ArrayDeque(); // queue containing indices, we are only interested in elements which are after the max window element
        // monotonically decreasing queue

        while(end < n){

            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[end] ){
                // pop last from the queue
                deque.pollLast();
            }
            // add nums[end] to the queue
            deque.offer(end);

            if(end - start + 1 == k){ // valid window, shrink now after calculating max
                res[start] = nums[deque.peek()];

                if(start == deque.peek()){
                    deque.pop();
                }
                // shrink here
                start++;
            }

            // expand here
            end++;
        }
        return res;
    }
}
