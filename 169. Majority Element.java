class Solution {
    // Approach: opponents reduce vote by 1
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int vote =0;

        for(int i=0; i < nums.length; i++){
            // cases we have 
            if(vote == 0){ //case1: candidate doesn't have a vote
                // make nums[i] candidate
                candidate = nums[i];
                vote++;
            }else if(candidate == nums[i]){ // case2: nums[i] is the candidate element
                vote++;
            }else { //case2: nums[i] is NOT the candidate element
                vote--;
            }
        }
        return candidate;
    }
}
