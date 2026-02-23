class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    // counst all subarrays which sum to goal
    int atMost(int[] nums, int goal) {
        if (goal < 0) return 0;

        int start = 0;
        int sum = 0;
        int count = 0;

        for (int end = 0; end < nums.length; end++) {

            sum += nums[end];

            // this condition is monotonic since we we have non-negative numbers
            // we could shrink with confidence ( which we can't do for sum == k due to lack of monotoncity)
            while (sum > goal) {
                sum -= nums[start];
                start++;
            }

            // all subarrays ending at 'end'
            // [end-1, end], [end-2, end] ... [start, end]
            count += (end - start + 1);
        }

        return count;
    }
}
