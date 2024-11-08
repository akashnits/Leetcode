class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int allXOR = 0;

        for(int num: nums){
            allXOR ^= num;
        }

        int maxKValue = (1 << maximumBit) -1;
        int n = nums.length;
        int[] res = new int[n];
        
        for (int i = 0; i < nums.length; i++) {
            res[i] = allXOR ^ maxKValue;
            // remove last element
            allXOR = allXOR ^ nums[n - 1 - i];
        }
        return res;
    }
}
