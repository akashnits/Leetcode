// Idea is to keep sum of sub_array and compare it with nums[i]
// if sub_array_sum < 0, we choose nums[i] as new sub_array_sum
// else add nums[i] to sub_array_sum
// compare with max_value and return

class Solution {
    public int maxSubArray(int[] nums) {
        int max_sum= Integer.MIN_VALUE;
        int sub_sum=0;
        
        for(int num: nums){
            //decide to include/exclude
            if(sub_sum < 0){
                // exclude this and set sub_sum=num
                sub_sum= num;
            }else{
                sub_sum += num; 
            }
            
            max_sum= Math.max(sub_sum, max_sum);
        }
        return max_sum;
    }
}
