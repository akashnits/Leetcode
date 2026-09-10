class Solution { 
    /* 
    this code can be re-written as:
    for (threshold = 1000; threshold <= n; threshold *= 1000) {
        ans += n - threshold + 1;
    }*/
    
    public long countCommas(long n) {
        long ans = 0;

        if (n < 1_000) {
            return 0;
        }

        // Every number from 1,000 onward contributes 1 comma
        ans += n - 1_000 + 1;

        if (n >= 1_000_000) {
            // Every number from 1,000,000 onward contributes one extra comma
            ans += n - 1_000_000 + 1;
        }

        if (n >= 1_000_000_000L) {
            ans += n - 1_000_000_000L + 1;
        }

        if (n >= 1_000_000_000_000L) {
            ans += n - 1_000_000_000_000L + 1;
        }

        if (n >= 1_000_000_000_000_000L) {
            ans += n - 1_000_000_000_000_000L + 1;
        }

        return ans;
    }
}
