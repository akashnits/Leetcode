class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        int res =0;
        for(int i=0; i < nums.length; i++){
            int ele = nums[i];

            // check if this exists
            if(map.containsKey(ele)){
                res += map.get(ele);
            }
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }
        return res;
    }
}
