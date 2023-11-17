class Solution {
    public int minPairSum(int[] nums) {
        int res = Integer.MIN_VALUE;
        int n = nums.length;
        // sort the array
        Arrays.sort(nums);

        // iterate over sorted array and make pair - first with last and so on...

        for(int i=0, j = n-1; j > i; ){
            // find max in sum of pair
            res = Math.max(res, nums[i] + nums[j]);
            i++;
            j--;
        }
        return res;
    }
}
