class KthLargest {
    // maintain a minHeap of size k, the top most element is the kth largest
    int K = 0;
    PriorityQueue<Integer> minHeap;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<Integer>((a, b) -> Integer.compare(a, b));
        K = k;
        // initialize
        for(int num: nums){
            minHeap.offer(num);
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        // maintain a heap size of K
        while(minHeap.size() > K){
            minHeap.poll();
        }

        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
