class Solution {
    int targetSum;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result= new ArrayList();
        targetSum= target;
        solve(candidates, 0, new ArrayList(), 0, result );
        return result;
    }
    
    
    void solve(int[] nums, int start, List<Integer> output, int currSum, List<List<Integer>> result){
        //base condition
        
        if(currSum > targetSum){
            return;
        }
        
        if(currSum == targetSum){
             result.add(new ArrayList(output));
            return;
        }
        
        for(int i=start; i < nums.length; i++){
            
            output.add(nums[i]);
            
            solve(nums, i, output, currSum+nums[i], result);
            
            output.remove(output.size()-1);
        }
    }
}
