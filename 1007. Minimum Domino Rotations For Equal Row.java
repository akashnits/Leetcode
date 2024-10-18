class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        // try making all tops values equal  - it could either be tops[0] ot bottoms[0]
        int n = tops.length;
        Integer[][][] dp = new Integer[2][7][20_001];
        
        int choice1 = solve(tops, bottoms, n, 1, tops[0], 0, dp);
        int choice2 = solve(tops, bottoms, n, 1, bottoms[0], 0, dp);

        // try making all bottom values equal  - it could either be tops[0] ot bottoms[0]
        int choice3 = solve(tops, bottoms, n, 0, tops[0], 0, dp);
        int choice4 = solve(tops, bottoms, n, 0, bottoms[0], 0, dp);

        int minForMakingAllTopsEqual = Math.min(choice1, choice2);
        int minForMakingAllBottomsEqual = Math.min(choice3, choice4);

        int res = Math.min(minForMakingAllTopsEqual, minForMakingAllBottomsEqual);

        return res > n? -1 : res;
    }


    int solve(int[] tops, int[] bottoms, int n, int isTop, int val, int i, Integer[][][] dp){
        // base condition: reached the end
        if(i == n){
            return 0;
        }

        if(dp[isTop][val][i] != null){
            return dp[isTop][val][i];
        }

        int ele1 = isTop == 1 ? tops[i]: bottoms[i];
        int ele2 = isTop == 1 ? bottoms[i]: tops[i];

        if(ele1 == val){
            // just recurse 
            dp[isTop][val][i] =  solve(tops, bottoms, n, isTop, val, i+1, dp);
            return dp[isTop][val][i];
        }

        if(ele2 == val) {
            dp[isTop][val][i] =  1 + solve(tops, bottoms, n, isTop, val, i+1, dp);
            return dp[isTop][val][i];
        }

        dp[isTop][val][i] =  n+1; // swaps could never be more than n
        return dp[isTop][val][i];
    }
}
