class Solution {
    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        int MOD= (int) 1e9 + 7;
        int res =0;
        int diff = 0;
        for(int i=0; i < nums.length; i++){
            diff = nums[i] - reverse(nums[i]);
            res = (res + map.getOrDefault(diff, 0)) % MOD;
            map.put(diff, map.getOrDefault(diff, 0) +1 );
        }
        return res;
    }

    public int reverse(int num){
        int result =0;
        while(num > 0){
            int remainder = num %10; // this is digit of interest
            result = result * 10 + remainder;
            num /= 10;
        }
        return result;
    }
}
