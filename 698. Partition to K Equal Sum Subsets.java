class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum =0;
        
        for(int num: nums){
            sum += num;
        }
        
        if( sum % k != 0 ) return false;
        
        if( k > sum ) return false;
        
        return partition(nums, new boolean[n], 0, sum/k , 0, k);
    }
    
    
    
    public boolean partition(int[] nums, boolean[] used, int start, int subsetSum, int currSum, int k){
        
        // base condition
        if( k == 1){
            return true;
        }
        
        if(currSum == subsetSum){
            return  partition(nums, used, 0, subsetSum, 0, k-1);
        }
        
        for(int i= start; i < nums.length; i++){
            
            if(!used[i] && nums[i] <= subsetSum - currSum){
                // we can include this
                used[i] = true;
                currSum += nums[i];
                if(partition(nums, used, i+1, subsetSum, currSum, k)){
                    // we recurse on our decision to find next subset
                    return true;
                }
                used[i] = false;
                currSum -= nums[i];
            }
        }
        return false;
    }
}
