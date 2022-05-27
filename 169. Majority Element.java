class Solution {
    public int majorityElement(int[] nums) {
        int count =0;
        int candidate=-1;
        for(int num: nums){
            if(count == 0){
                // pick a new candidate
                candidate = num;
            }
            count = (candidate == num ? ++count: --count);
        }
        return candidate;
    }
}
