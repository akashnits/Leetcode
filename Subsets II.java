class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        //trying the backtracking way
          List<List<Integer>> list = new ArrayList<>();
          return subsetsWithDupHelper(0, nums, new ArrayList(), list);
    }


    private List<List<Integer>> subsetsWithDupHelper(int start, int[] nums, List<Integer> subset,
               List<List<Integer>> resultList){

        resultList.add(new ArrayList(subset));
        for(int i = start; i < nums.length; i++){
            //can we select this path ?
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            subset.add(nums[i]);
            //backtrack
            subsetsWithDupHelper(i+1, nums, subset, resultList);
            //remove last
            subset.remove(subset.size()-1);
        }
        return resultList;
    }
}
