class Solution {
    public int findTheWinner(int n, int k) {
        // recurrence relation
        // f(n, k) = f(n-1, k) + k % n
        // Whenever we remove a friend, start index shifts by -k
        // % n to account for wrap around

        Integer[] dp = new Integer[n+1];
        return findWinnerIndex(n, k, dp) + 1;
    }

    int findWinnerIndex(int n, int k, Integer[] dp){
        if(n == 1){
            return 0;
        }

        if(dp[n] != null){
            return dp[n];
        }
        
        return dp[n] = (findWinnerIndex(n-1, k, dp) + k) % n;
    }
}
