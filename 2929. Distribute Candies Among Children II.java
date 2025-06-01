// how many candies child at ith position can have ?
// anywhere b/w 0...min(limit, remainingCandies)
class Solution {
    public long distributeCandies(int n, int limit) {
        // Long[][] dp = new Long[n+1][3];
        // return countNumWays(limit, n, 0, dp);

        // let first child get x candies, now we are left with (n-x) candies
        // if (n-x) > 2 * limit, as max candies a child can have is limit
        // if (n-x) <= 2 * limit
        // (third child can have 0 to limit) and (second child can have n-x-limit to n-x)
        long ans = 0;
        for (int i = 0; i <= Math.min(limit, n); i++) {
            if (n - i > 2 * limit) {
                continue;
            }
            ans += Math.min(n - i, limit) - Math.max(0, n - i - limit) + 1;
        }
        return ans;
    }

    // TLE using sp solution
    // Time complexity for dp soln: O ( 3* n * limit)
    // 3 * n for subproblems and limit for solving each subproblem
    long countNumWays(int limit, int n, int idx, Long[][] dp){
        // base condition: 
        // 1. all candies over
        if(n == 0){
            return 1; 
        }

        if(idx == 3){
            // no more child to distibute to
            return n > 0 ? 0: 1;
        }

        if(dp[n][idx] != null){
            return dp[n][idx];
        }

        long countWays = 0;
        // choices - child at idx element could get anywhere b/w 0...min(limit, n) candies
        for(int numCandy =0; numCandy <= Math.min(limit, n); numCandy++){
            // take the candy and recurse
            countWays += countNumWays(limit, n-numCandy, idx+1, dp);
        }
        return dp[n][idx] = countWays;
    }
}
