class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList();
        for(int num: nums){
            int idx = Math.abs(num)-1;
            if(nums[idx] < 0){
                // negative value means that it had been reached earlier
                result.add(idx+1);
            }else{
                nums[idx] *= -1;
            }
        }
        return result;
    }
}
