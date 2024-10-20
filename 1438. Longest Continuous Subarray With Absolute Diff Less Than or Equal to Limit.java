class Solution {
    public int longestSubarray(int[] nums, int limit) {
        // how else could we calculate min/max in a range ?
        // using monotonic increasing/decreasing queue

        ArrayDeque<Integer> maxQueue = new ArrayDeque<Integer>(); // decreasing
        ArrayDeque<Integer> minQueue = new ArrayDeque<Integer>(); // increasing

        int start =0;
        int end = 0;
        int maxLength = 1;

        int n = nums.length;
        while(end < n){
            // add incoming element to both the queue, before that make room for new element
            while(!maxQueue.isEmpty() && nums[maxQueue.peekLast()] <= nums[end]){
                maxQueue.pollLast();
            }
            while(!minQueue.isEmpty() && nums[minQueue.peekLast()] >= nums[end]){
                minQueue.pollLast();
            }

            // expand here
            maxQueue.offer(end);
            minQueue.offer(end);

            int max = nums[maxQueue.peek()];
            int min = nums[minQueue.peek()];
            // check if we it violated the limit i.e. Math.abs(max - min ) > limit
            while(Math.abs(max - min) > limit){
                // we shrink until it's valid again
                if(start == maxQueue.peek()){
                    // max value is going out
                    maxQueue.pop();
                    // we have a new max
                    max = nums[maxQueue.peek()];
                }

                if(start == minQueue.peek()){
                    // min value is going out
                    minQueue.pop();
                    // we have a new min
                    min = nums[minQueue.peek()];
                }
                start++;
            }
            // we have a valid window here
            maxLength = Math.max(maxLength, end - start +1);
            end++;
        }
        return maxLength;
    }
}
