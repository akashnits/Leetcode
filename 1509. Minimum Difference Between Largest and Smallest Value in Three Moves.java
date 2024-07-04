class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        if (n <= 4) return 0;
        int minDiff = Integer.MAX_VALUE;

        // Four scenarios to compute the minimum difference /
        // remove 3 largest elements or 2 largest, 1 smallest or 2 smallest, 1 largest or 3 smallest 
        for (int left = 0, right = n - 4; left < 4; left++, right++) {
            minDiff = Math.min(minDiff, nums[right] - nums[left]);
        }

        return minDiff;
    }
}
