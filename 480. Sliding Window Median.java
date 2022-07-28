class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        
        double[] result = new double[n-k+1];
        // create a minHeap and maxHeap 
    
        PriorityQueue<Double> minHeap = new PriorityQueue<Double>
            ((a, b) -> Double.compare(a, b));
        PriorityQueue<Double> maxHeap = new PriorityQueue<Double>
            ((a, b) -> Double.compare(b, a));

        int i=0, j=0;
        int windowLength = 0;
        int idx =0;
        
        while( j < n ){
             // we insert value in heap
             if(maxHeap.size() > minHeap.size()) {
                // we add in minHeap
                minHeap.add(Double.valueOf(nums[j]));
            }else {
                // we add in max heap
                maxHeap.add(Double.valueOf(nums[j]));
             }
            
            // we rebalance after adding - check if top of maxHeap is > top of min heap
            if(minHeap.size() > 0 && maxHeap.size() > 0 && minHeap.peek() < maxHeap.peek()){
                // swap it
                double min = minHeap.poll();
                double max = maxHeap.poll();
                
                minHeap.add(max);
                maxHeap.add(min);
            }
            
            windowLength = j-i+1;
            // check if candidate
            if(windowLength == k){
                // get the median
                result[idx++] = getMedian(minHeap, maxHeap, k);
            }
            
            // check if we should shrink the window
            if(windowLength == k){
                // we need to shrink it so that we can expand it to maintain constant size
                // remove the element from heap 
                Double ele = Double.valueOf(nums[i]);
                if(minHeap.contains(ele)){
                    minHeap.remove(ele);
                }else{
                    maxHeap.remove(ele);
                }
                i++;
            }
            j++;
        }
        return result;
    }
    
    double getMedian(PriorityQueue<Double> minHeap, PriorityQueue<Double> maxHeap, int k){
        if(k % 2 == 0){
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }else{
            return maxHeap.peek();
        }
    }
    
}
