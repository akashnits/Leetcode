class Solution {
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> permute(int[] nums) {
        solve(nums, new ArrayList());
        return result;
    }
    
    void solve(int[] nums, List<Integer> op){

        if(op.size() > nums.length){
            return;
        }
        
        if(op.size() == nums.length){
            result.add(new ArrayList(op));
            return;
        }
        
        for(int i=0; i < nums.length; i++){
            if(op.contains(nums[i])) continue;
            op.add(nums[i]);
            solve(nums, op);
            op.remove(op.size()-1);
        }
    }
}
