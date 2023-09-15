class Solution {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        // sort offers array as per house number
        Collections.sort(offers, (a, b) -> ( a.get(0) == b.get(0) ? a.get(1) - b.get(1): a.get(0) - b.get(0)));
        int[] dp = new int[offers.size()];
        Arrays.fill(dp, -1);

        return calculateProfit(offers, offers.size(), 0, dp);
    }


    int calculateProfit(List<List<Integer>> offers, int m, int idx, int[] dp){
        if(idx == -1 || idx == m){ // reached last offer
            return 0;
        }

        if(dp[idx] != -1){
            return dp[idx];
        }

        // two choices, sell or don't
        dp[idx]= Math.max(offers.get(idx).get(2) + 
                    calculateProfit(offers, m, findNextHouse(offers, idx+1, m-1, offers.get(idx).get(1)), dp), 
                    calculateProfit(offers, m, idx+1, dp));
        return dp[idx];            
    }


    int findNextHouse(List<List<Integer>> offers, int l, int r, int lastHouseSold ){
        // we must find a house having index greater than last house sold
        int idx = -1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(offers.get(mid).get(0) > lastHouseSold){
                // possible candidate
                idx = mid;
                // go left as we want to find just greater
                r = mid-1;
            }else{
                // go right
                l = mid+1;
            }
        }
        return idx;
    }
}
