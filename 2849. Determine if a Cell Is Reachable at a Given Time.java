class Solution {
    // Approach: calculate min time to reach the destination
    // We get minTime whiel travelling diagonally. The diagonal distance is max(xDistance, yDistance)
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        
        // coner case
        if(Math.abs(fy-sy) == 0 && Math.abs(fx-sx) == 0 && t == 1) return false;
        int minTime = Math.max(Math.abs(fy-sy), Math.abs(fx-sx));

        return t >= minTime? true: false;
    }
}
