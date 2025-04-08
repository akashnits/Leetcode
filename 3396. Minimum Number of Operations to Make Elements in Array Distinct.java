class Solution {
    public int minimumOperations(int[] nums) {
        // iterate from last, stop if we see a duplicate
        int n = nums.length;
        Set<Integer> set = new HashSet();

        int idx = -1;
        for(int i=n-1; i >= 0; i--){
            if(set.contains(nums[i])){
                idx = i;
                break;
            }else{
                set.add(nums[i]);
            }
        }

        // number of elements to remove = idx + 1
        int numEleRemove = idx +1;

        // operations to do this 
        return (int) Math.ceil(numEleRemove / 3.0);
    }
}
