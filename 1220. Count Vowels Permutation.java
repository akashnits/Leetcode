class Solution {
    public int countVowelPermutation(int n) {
        // To avoid the large output value
        int MOD = (int)(1e9 + 7);
 
        // dp[i][char] represents number of ways to reach char when path length is i
        // Initialize 2D dp array
        long[][] dp = new long[n + 1][5];
 
        // Initialize dp[1][i] as 1 since
        // string of length 1 will consist
        // of only one vowel in the string
        for (int i = 0; i < 5; i++) {
            dp[1][i] = 1; // path length to self is one
        }
 
        //using adjacency matrix
        List<List<Integer>> graph = new ArrayList();
        for(int j=0; j < 5; j++){
            graph.add(j, new ArrayList());
        }
        
        // build graph to represent vowel relation u -> v edge
        graph.get(0).add(1);
        graph.get(1).add(0);
        graph.get(1).add(2);
        graph.get(2).add(0);
        graph.get(2).add(1);
        graph.get(2).add(3);
        graph.get(2).add(4);
        graph.get(3).add(2);
        graph.get(3).add(4);
        graph.get(4).add(0);
        
 
        // we need to find all N length paths ending at all chars (a,e,i,o,u)
        
        // Iterate over the range [2, N], path length
        for (int i = 2; i <= n; i++) {
 
            // for each vertex
            for (int u = 0; u < 5; u++) {
                dp[i][u] = 0; // no way to reach self with path length > 1
 
                // Traversing the neighbors
                for (int v : graph.get(u)) {
 
                    // we have path fron u -> v
                    // so, i length path to reach u is sum of  i-1 length path to all it's neightbors
                    dp[i][u] += dp[i-1][v] % MOD;
                }
            }
        }
 
        // summing n-length path to reach all chars gives the ans
        long ans = 0;
 
        for (int i = 0; i < 5; i++) {
            ans = (ans + dp[n][i]) % MOD;
        }
 
        // Return count of permutations
        return (int)ans;
    }
}
