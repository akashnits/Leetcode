class Solution {
    // sliding windwow min size - distninct elements
    // sliding window max size - whole array
    public int countCompleteSubarrays(int[] nums) {
        
        int distEleCount = 0;
        int n = nums.length;
        
        Set<Integer> set = new HashSet();
        
        for(int num: nums){
            set.add(num);
        }
        
        distEleCount = set.size();
        // sliding window size [distEleCount, n]
        
        // count distinct elements in all subarrays where distinct elem == arry distinct elem
        int count =0;
        
            
            // create a windowMap of size ws
            for(int ws = distEleCount; ws <= n; ws++ ){
                HashMap<Integer, Integer> windowMap = new HashMap();
                
            
                // sliding window algorithm here
                int start = 0;
                int end = 0;
            
                // window of size ws
                while(end < n){
                    
                    windowMap.put(nums[end], windowMap.getOrDefault(nums[end], 0) + 1);
                    
                    // if windows size equals given size
                    if( end-start+1 == ws ){
                        // check if valid window
                        if(windowMap.size() == distEleCount){
                            count++;
                        }
                        
                        // make window invalid - shrink here
                        windowMap.put(nums[start], windowMap.get(nums[start])-1);
                        if(windowMap.get(nums[start]) == 0){
                            windowMap.remove(nums[start]);
                        }
                        start++;
                    }
                    
                    // expand here
                    end++;
                }
            }
        
        return count;
    }
}
