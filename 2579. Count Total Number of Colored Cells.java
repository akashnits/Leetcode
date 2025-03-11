class Solution {
    // number of cells added at each iteration is in series 
    // 4, 8, 12, 16...
    public long coloredCells(int n) {
        // s= n/2 [2*a + (n-1)d]
        // 1 + 4 * [1 + 2 + 3.....n]
        // sum of series
        return 1 + 2 * (n - 1) * n;
    }
}
