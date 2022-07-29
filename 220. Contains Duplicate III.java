class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        
        // idea is to maintain a treeSet of size k and search a value which is >= abs(nums[j]-t)
        
        // we shrink the window when windowLength > k
        
        int n = nums.length;
        int i=0, j=0;
        
        int windowLength =0;
        TreeSet<Long> treeSet = new TreeSet();
        
        while(  j < n ){
            
            //  search a value >= abs(nums[j] -t)
            //  decide if we can true and exit
            if(treeSet.size() > 0){
                // search here
                Long floor = treeSet.floor(nums[j] + (long)t);
                Long ceil = treeSet.ceiling(nums[j] - (long)t);
                
                if((floor != null && floor >= nums[j]) ||  
                   (ceil != null && ceil <= nums[j])){
                    return true;
                }
                
            }
            
            //  add nums[j] to treeSet
            treeSet.add((long) nums[j]);
            
            // calculate window length
            windowLength = j-i+1;
            
            // check if windowLength > k, we shrink
            // drop nums[i] from treeSet and increment i
            
            if(windowLength > k){
                treeSet.remove((long)nums[i]);
                i++;
            }
            
            j++;
        }
        return false;
    }
}
