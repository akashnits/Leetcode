class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<Integer>();
        int n = nums.length;
        int[] result = new int[n-k+1];
        int lo=0; 
        int hi =0;
        
        while(hi <= n-1){
            
            // we exapnd here
            while(!queue.isEmpty() && nums[hi] > queue.peekLast()){
                // we pop from back of queue
                queue.pollLast();
            }
            queue.offer(nums[hi]);
            
            
            // we check if desired window reached
            int windowSize = hi-lo+1;
            if(windowSize == k){
                // front of the queue contains max value
                result[lo] = queue.peek();
                
                // time to shrink the window
                if(nums[lo] == queue.peek()){
                    // we need to pop front as we shrink
                     queue.pop();
                }
                lo++;
            }
            hi++;
        }
        
        return result;
    }
}
