class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // the number of majority elements which appear more than n/3 times can be 0,1,2
        List<Integer> res = new ArrayList();

        // candidates and their corresponding votes
        int candidate1 = 0;
        int candidate2 =0;
        int vote1 =0;
        int vote2 = 0;

        for(int i=0; i < nums.length; i++){
            // case 1: nums[i] is candidate1
            if(candidate1 == nums[i]){
                vote1++;
            }else if(candidate2 == nums[i]){ // case 2: nums[i] is candidate2
                vote2++;
            }else if(vote1 == 0){
                // make nums[i] as candidate1
                candidate1 = nums[i];
                vote1++;
            }else if(vote2 == 0){
                // make nums[i] as candidate2
                candidate2 = nums[i];
                vote2++;
            }else{
                // nums[i] was neither candidate1 nor candidate2 abd candidate1/candidate2 has some votes
                // decrement the votes of candidate1/candidate2
                vote1--;
                vote2--;
            }
        }

        // we have the possible majority candidates now, 
        // check the votes of candidate1 and candidate2 and include in answer if greater than n/3


        int count1=0;
        int count2=0;

        for(int i=0; i < nums.length; i++){
            if(nums[i] == candidate1){
                count1++;
            }else if(nums[i] == candidate2){
                count2++;
            }
        }

        if(count1 > nums.length/3){
            res.add(candidate1);
        }

        if(count2 > nums.length/3){
            res.add(candidate2);
        }

        return res;
    }
}
