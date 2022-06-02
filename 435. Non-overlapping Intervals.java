class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int count=0;
        
        int end = intervals[0][1];
        for(int i=1; i < intervals.length; i++){
            int[] interval= intervals[i];
            
            //merge if incoming interval's start element is less than end element of result
            if(interval[0] < end){
                //merge
                end= Math.min(end, interval[1]);
                count++;
            }else{
                end = interval[1];
            }
        }

    return count;
    }
}
