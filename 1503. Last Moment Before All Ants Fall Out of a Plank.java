class Solution {
    // Imp: the fact that when ants collide, their velocities are excahnged
    // it's same as if they pass each other
    public int getLastMoment(int n, int[] left, int[] right) {
        int ans = 0;
        // calculate distance of ants moving left from the start
        for (int num : left) {
            ans = Math.max(ans, num);
        }
        
        // calculate distance of ants moving right from the end
        for (int num : right) {
            ans = Math.max(ans, n - num);
        }
        
        // the ant which needs to cover max distance falls off the plank at the last
        return ans;
    }
}
