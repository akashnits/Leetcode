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
}
