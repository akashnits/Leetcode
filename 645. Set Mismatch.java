class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int actual_sum = n * (n + 1) / 2;
        int array_sum = 0;
        int unique_sum = 0;
        Set<Integer> s = new HashSet<>();

        for (int a : nums) {
            array_sum += a;
            if(s.add(a)){
                unique_sum += a;
            }
        }

        

        int missing = actual_sum - unique_sum;
        int duplicate = array_sum - unique_sum;

        return new int[]{duplicate, missing};
    }
}
