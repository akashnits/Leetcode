class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;

        int[] dp = new int[n]; // longest word chain ending at i
        Arrays.fill(dp, 1);

        // sort based on length
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int maxLen = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {

                // check if words[j] is predecessor of words[i]
                if (isPredecessor(words[j], words[i])) {

                    // extend the chain ending at j
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }

            // update longest chain
            if (dp[i] > maxLen) {
                maxLen = dp[i];
            }
        }

        return maxLen;
    }

    boolean isPredecessor(String smaller, String bigger) {
        // bigger must have exactly one extra character
        if (bigger.length() != smaller.length() + 1)
            return false;

        int i = 0; // smaller
        int j = 0; // bigger
        boolean haveBuffer = true;

        while (i < smaller.length() && j < bigger.length()) {
            if (smaller.charAt(i) == bigger.charAt(j)) {
                // matching character -> move both
                i++;
                j++;
            } else {
                // extra character in bigger -> skip it
                if(!haveBuffer){
                    return false; // char mismatch but no buffer
                }
                j++;
                haveBuffer = false;
            }
        }

        // we should have matched every char in smaller
        return true;
    }
}
