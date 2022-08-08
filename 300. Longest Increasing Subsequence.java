class Solution {
    public int lengthOfLIS(int[] nums) {
        // this is O(n^2) solution
//         int n = nums.length;
//         int[] dp = new int[n];
//         Arrays.fill(dp, 1); // length of each element is 1
//         int maxLength = 1;
        
//         for(int i=1; i < n; i++){
//             for(int j=0; j < i; j++){
//                 if(nums[i] > nums[j]){
//                     // possible candidate
//                     dp[i] = Math.max(dp[i], dp[j]+1);
//                 }
//             }
//             maxLength = Math.max(maxLength, dp[i]);
//         }
//          return maxLength;
        
       //  O(nlogn) solution
        
        int n = nums.length;
        int[] dp = new int[n];
        
        // initialization
        dp[0] = nums[0];
        
        int endIdx = 0; //  index for iterating dp array
        // loop over nums array
        for( int i=1 ; i < n; i++){
            // compare dp[endIdx] with nums[i]
            
            if(dp[endIdx] == nums[i]){
                // ignore as we want strictly increasing
                continue;
            }else if(dp[endIdx] < nums[i]){
                // strictly increasing, include this in dp array
                dp[++endIdx] = nums[i];
            }else{
                // find index of value which is just greater than nums[i] in dp array
                int ceilIdx = findCeilIndex(dp, 0, endIdx, nums[i]);
                // replace value at ceil index with incoming value
                if(ceilIdx != -1){
                    dp[ceilIdx] = nums[i];
                }
            }
        }
        
        return endIdx+1;
    }
    
    int findCeilIndex(int[] arr, int start, int end, int target){
        if(start > end){
            // can't search anymore
            return start; // returns the index of element which is just greater than target
        }
        
        int mid = start + (end-start)/2;
        
        if(arr[mid] == target){
            return -1;
        }
        
        if(arr[mid] > target){
            // search in left half
            return findCeilIndex(arr, start, mid-1, target);
        }else{
            // search in right half
            return findCeilIndex(arr, mid+1, end, target);
        }
    }
}
