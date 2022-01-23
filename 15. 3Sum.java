class Solution {
    
    //Imp: Skip duplicates at all three elements.
    
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList();
        // sort the array
        Arrays.sort(nums);
        //iterate over array and skip duplicates
        for(int i=0; i < nums.length-2; i++){
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            solve(nums, -nums[i], i+1, nums.length-1, result);
        }
        return result;
    }
    
    private void solve(int[] nums, int ele, int l, int r, List<List<Integer>> result){
        // a + b = -c
        while(l < r){
            if(nums[l] + nums[r] == ele){
                // we have got one triplet, add to result and move ahead
                List<Integer> triplet = new ArrayList();
                triplet.add(-ele);
                triplet.add(nums[l]);
                triplet.add(nums[r]);
                
                result.add(triplet);
                
                // skip duplicates at l and r
                while(l < nums.length-1 && nums[l] == nums[l+1]){
                    l++;
                }
                
                while(r > 1 && nums[r-1] == nums[r]){
                    r--;
                }
                
                l++;
                r--;
            }else if(nums[l] + nums[r] > ele){
                r--;
            }else{
                l++;
            }
        }
    }
}
