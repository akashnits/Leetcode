class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // sort ascending by start and decending by end to keep the intervals large
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]){
                return Integer.compare(b[1], a[1]);
            }else{
                return Integer.compare(a[0], b[0]);
            }
        });

        int l =0, r = 1;

        int n = intervals.length;
        int res = n;

        while( r < n){
            // compare interval at l and r
            int[] left = intervals[l];
            int[] right = intervals[r];

            if(left[0] <= right[0] && left[1] >= right[1]){
                // right interval is covered completely
                res--;
                r++; // keep left as is, move r
            }else{
                // not covered fully
                l = r; r++;
            }
        }

        return res;
    }
}
