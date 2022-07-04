class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        // create a minHeap storing indices i and j such that nums1[i] + nums[j] is minimum
        // i points to element in nums1, j points to element in nums2
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]);
        
        List<List<Integer>> result = new ArrayList();
        
        if(nums1.length == 0 || nums2.length == 0 || k == 0){
            return result;
        }
        // initilaize pq
        for(int i=0; i < nums1.length && i < k; i++){
            pq.offer(new int[]{i, 0});
        }
        
        
        while(k-- > 0 && !pq.isEmpty()){
            int[] indices = pq.poll();
            
            List<Integer> temp = new ArrayList();
            temp.add(nums1[indices[0]]);
            temp.add(nums2[indices[1]]);
            result.add(temp);
            
            // check we can increment j
            if(nums2.length-1 == indices[1]) continue;
            
            pq.offer(new int[]{indices[0], indices[1]+1});
        }
        
        return result;
    }
}
