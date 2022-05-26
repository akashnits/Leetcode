class Solution {
    public int missingNumber(int[] nums) {
        // idea is XOR indices with nums, missing number would be index which couldn't find any number to XOR with - a ^ a ^b = b
        int n = nums.length;
        int missing=0;
        for(int i=0; i < n; i++){
            missing ^= nums[i] ^ i;
        }
        return missing ^n;
    }
}
