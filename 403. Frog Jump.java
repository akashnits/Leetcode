class Solution {
    int[] jumps = {-1, 0, 1};
    public boolean canCross(int[] stones) {
       if(stones[1] != 1) return false;
       int n = stones.length+1;
       int m = 2001;
       Map<String, Boolean> map = new HashMap();
       return frogJump(stones, 1, 1, map); 
    }

    boolean frogJump(int[] stones, int currIdx, int lastJump, Map<String, Boolean> dp){
        if(currIdx == stones.length-1){
            // frog has reached destination
            return true;
        }

        if(dp.containsKey(currIdx + "_" + lastJump)){
            return dp.get(currIdx + "_" + lastJump);
        }

        // choices we have - can jump -> lastJump-1, lastJump, lastJump+1 
        for(int jump: jumps){
            int nextJump = lastJump + jump; // jump units
            
            // make a jump and return the index of the stone it reached
            int nextIdx = binarySearch(stones, currIdx+1, stones.length-1, nextJump+stones[currIdx]);

            if(nextIdx == currIdx || nextIdx == -1) continue; // couldn't reach anywhere with this jump

            boolean res = frogJump(stones, nextIdx, nextJump, dp);
            if(res) {
                dp.put(currIdx + "_" + lastJump, true);
                return true;
            }
        }
        dp.put(currIdx + "_" + lastJump, false);
        return false;
    }

    int binarySearch(int[] stones, int l, int r, int target) {

        while(l <= r){
            int mid = l + (r-l)/2;
            if(stones[mid] == target){
                return mid;
            }else if(stones[mid] > target){
                // go left
                r = mid-1;
            }else{
                // go right
                l = mid+1;
            }
        }
        return -1;
    }
}
