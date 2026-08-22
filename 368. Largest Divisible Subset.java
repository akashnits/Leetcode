class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n]; // represents the longest divisible subset
        Arrays.fill(dp, 1);

        Arrays.sort(nums); // so we onlyu have to divide nums[i] ny nums[j]
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        int startIdx = 0;
        int maxLen = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // check if divisible
                if (nums[i] % nums[j] == 0) {
                    // we can take the max
                    if (dp[j] + 1 > dp[i]) {
                        // we should include this candidate and calculate maxLen
                        dp[i] = dp[j] + 1;
                        // link from i -> j
                        parent[i] = j;
                    }
                }
            }
            // check if this is maxLen ?
            if (dp[i] > maxLen) {
                // this subset is currently longest 
                maxLen = dp[i];
                startIdx = i;
            }
        }

        List<Integer> res = new ArrayList();

        int k = startIdx;
        // iterate from startIdx and reconstruct 
        while (k != -1) {
            res.add(nums[k]);
            k = parent[k];
        }

        return res;
    }
}
