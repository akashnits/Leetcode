class Solution {
    public int minOperations(int[] nums, int k) {
        int minOps =0;

        int xorAllEle = nums[0];

        for(int i=1; i < nums.length; i++){
            xorAllEle ^= nums[i];
        }

        for(int j=0; j < 32; j++){
            // mask at j
            int mask = (1 << j);
            if( (mask & xorAllEle) != (mask & k)){
                minOps++;
            }
        }
        return minOps;
    }
}
