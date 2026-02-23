class Solution {
    // hint: count number of subarrays with K exact odd numbers
    // likely a problem to be solved by atMost since oddCount == k wouldn't give monotoncity but oddCount <= k would do
    public int numberOfSubarrays(int[] nums, int k) {
        return solve(nums, k) - solve(nums, k-1);
    }


    // find all subarrays with at most K odd numbers i.e. oddCount <= K
    int solve(int[] nums, int k){
        int start = 0, end = 0;
        int oddCount = 0;
        int n = nums.length;

        int subArrayCount = 0;

        while(end < n){
            if(nums[end] % 2 == 1){
                oddCount++;
            }

            // we shrink if oddCount > k
            while(oddCount > k){
                if(nums[start] % 2 == 1){
                    oddCount--;
                }
                start++;
            }

            // compute all subarray which has oddCount <= k, ending at end
            subArrayCount += end- start+1;

            end++;
        }

        return subArrayCount;
    }
}
