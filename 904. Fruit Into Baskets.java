class Solution {
    // approach: at any given point, the window can't have more that 2 type of fruits
    // variable size sliding window pattern - keep track of type of tree ( use a map)
    // return maxLength of the window

    // notes: we can use dp as well but the complexity would be more. The reason Sliding window works is due to the fact that
    // ONCE you pick a fruit , you can't skip picking. This leads to contigous array patten and the problem transform to finding the longest 
    // subarray with at most 2 distinct elements
    // If you were allowed to skip fruits after picking  the first one, we need to use recursion/dp

    
    public int totalFruit(int[] fruits) {
        int count = 0; // keeps track of type of trees in the window
        Map<Integer, Integer> windowsMap = new HashMap(); // maps type -> freq

        int n = fruits.length;
        int start = 0, end =0;
        int res = 0;

        while( end < n){
            // put the fruit in the basket
            int type = fruits[end];
            windowsMap.put(type, windowsMap.getOrDefault(type, 0) + 1);
            if(windowsMap.get(type) == 1) {
                count++; 
            }

            while(start <= end && count > 2 ){ // shrink until window becomes valid
                // take out fruits from the basket
                int typeStart = fruits[start];
                if(windowsMap.containsKey(typeStart)){
                    // drop this
                    windowsMap.put(typeStart, windowsMap.get(typeStart) -1);
                    if(windowsMap.get(typeStart) == 0){
                        // no fruit of this type in the window now
                        windowsMap.remove(typeStart);
                        count--;
                    }
                }
                start++; // shrink here
            }

            // we have a valid window here
            res = Math.max(res, end-start+1);

            end++; // expand here
        }

        return res;
    }

// DP solution
class Solution {
    private final Map<String, Integer> memo = new HashMap<>();

    public int totalFruit(int[] fruits) {
        // idx, type1, type2, started=false initially
        return dp(fruits, 0, -1, -1, false);
    }

    private int dp(int[] fruits, int idx, int type1, int type2, boolean started) {
        if (idx == fruits.length) return 0;

        String key = idx + "|" + type1 + "|" + type2 + "|" + (started ? 1 : 0);
        Integer cached = memo.get(key);
        if (cached != null) return cached;

        int f = fruits[idx];
        int ans;

        if (!started) {
            // Option 1: don't start here (skip)
            int skip = dp(fruits, idx + 1, type1, type2, false);
            // Option 2: start here by picking this fruit, put in basket 1
            int take = 1 + dp(fruits, idx + 1, f, -1, true);
            ans = Math.max(skip, take);
        } else {
            // Already started: must pick or stop (no skipping)
            if (f == type1 || f == type2) {
                ans = 1 + dp(fruits, idx + 1, type1, type2, true);
            } else if (type2 == -1) {
                // second basket still empty: fill it and pick
                ans = 1 + dp(fruits, idx + 1, type1, f, true);
            } else {
                // third type with both baskets full: must stop
                ans = 0;
            }
        }

        memo.put(key, ans);
        return ans;
    }
}

}
