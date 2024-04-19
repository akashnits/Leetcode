class Solution {
    // approach: count set bits at each position ( 32 bits) and take %3 to see if it 
    // occurs less than 3 i.e. just once
    // we include this bit in the answer
    public int singleNumber(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int mask = 1;

        // loop over all bits
        for(int i=0; i < 32; i++){
            int count = 0; // count set bits at position i
            for(int num: nums){
                count += (num >> i) & 1; // rightShift the number by i bits and AND with 1 to find 0 or 1 i.e. bit is set or not
            }

            // check if count is multiple of 3, if not include in answer
            if(count % 3 != 0){
                ans += (1<<i);
            }
        }
        return ans;
    }
}
