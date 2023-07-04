class Solution {
    // one = ( one ^ num ) & ( 1's complement of two )
    // two = ( two ^ num ) & ( 1's complement of one )
    // detailed explanation: https://leetcode.com/problems/single-number-ii/solutions/43295/detailed-explanation-and-generalization-of-the-bitwise-operation-method-for-single-numbers/
    
    public int singleNumber(int[] nums) {
        int ones = 0, twos= 0;
        for(int i=0; i< nums.length; i++){
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }

        return ones;
    }
}
