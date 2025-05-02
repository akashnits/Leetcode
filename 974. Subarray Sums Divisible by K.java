class Solution {
    // [4, 5, 0, -2, -3, 1] % 5
    // [4, 9, 9, 7, 4, 5] -> preSum
    // [4, 4, 4, 2, 4, 0] -> remainder
    // Idea: if we see the same remainder again, it means that there's a subarray which is completely divisible
    // say remainder at i, j are same, then we have a subarray (i, j] which is completely divisible
    // How many subarrays ? -> number is i's which has same remainder where i < j
    // so, we need to keep track of remainder with count

    // imp: Edge case: Don't save remainder in -ve number rather positive
    // -4 is same as 3 if k == 7
    public int subarraysDivByK(int[] nums, int k) {
        // keep track of remainder -> count
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1); // initialize for preSum problems

        int n = nums.length;
        int[] remainder = new int[n];
        int preSum = 0;
        int res =0;

        for(int i=0; i < n; i++){
            preSum += nums[i];
            remainder[i] = preSum % k;
            if(remainder[i] < 0){
                // add k
                remainder[i] += k; 
            }

            // check if we have seen this ?
            if(map.containsKey(remainder[i])){
                // get the count
                res += map.get(remainder[i]);
            }
            // put it in the map
            map.put(remainder[i], map.getOrDefault(remainder[i], 0) + 1);
        }
        return res;
    }
}
