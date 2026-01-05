class Solution {
    // pattern like this : R U R U R U or U U U R R R or R R U U R U
    // pigeonhole principle, limited slots - we need to assign a bunch of repeated chars so unique/repeated chars can only be spaced out by a limit i.e. max distance 2 in this case  
    public int repeatedNTimes(int[] nums) {
        int repeatedElement = -1;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == nums[i + 1] || nums[i] == nums[i + 2]) {
                repeatedElement = nums[i];
            }
        }

        // it maybe that the last two elements are repeated i.e. n-1, n-2
        // we din't compare them 
        return repeatedElement == -1 ? nums[nums.length-1]: repeatedElement;
    }
}
