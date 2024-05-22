class Solution {
    Set<List<Integer>> res = new HashSet();
    public List<List<Integer>> findSubsequences(int[] nums) {
        // subset should satisfy
        // 1. number of elements > 1
        // 2. increasing or equal
        int n = nums.length;

        generateNonDecreasingSubset(nums, 0, new ArrayList());
        return new ArrayList(res);
    }

    void generateNonDecreasingSubset(int[] nums, int start, List<Integer> subset){
        // choices we have - loop from start to end
        for(int i= start; i < nums.length; i++){
            int curr = nums[i];
            if(subset.isEmpty() || curr >= subset.get(subset.size()-1)){
                // add to subset
                subset.add(curr);
                //check if subset size >= 2
                if(subset.size() > 1){
                    res.add(new ArrayList(subset));
                }
                // recurse
                generateNonDecreasingSubset(nums, i+1, subset);
                // un-do
                subset.remove(subset.size()-1);
            }
        }
    }
}
