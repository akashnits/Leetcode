class Solution {
    // 23:59 00:10
    // 11:28 12:24 or 12:29
    public int findMinDifference(List<String> timePoints) {
        // different cases
        // h2 > h1 
        // h2 == h1 and m2 > m1
        // all other

        // sort the timePoints
        Collections.sort(timePoints, (time1, time2) -> {
            int h1 = Integer.parseInt(time1.substring(0,2));
            int h2 = Integer.parseInt(time2.substring(0,2));
            int m1 = Integer.parseInt(time1.substring(3,5));
            int m2 = Integer.parseInt(time2.substring(3,5));

            if(h1 == h2){
                return m1- m2;
            }else{
                return h1-h2;
            }
        });

        int n = timePoints.size();
        int minAbsDiffMinutes = Integer.MAX_VALUE;
        for(int i =1; i < n; i++){
            String currTime = timePoints.get(i);
            String prevTime = timePoints.get(i-1);

            // compare both 
            int currH = Integer.parseInt(currTime.substring(0, 2));
            int currM = Integer.parseInt(currTime.substring(3,5));
            int prevH = Integer.parseInt(prevTime.substring(0, 2));
            int prevM = Integer.parseInt(prevTime.substring(3,5));

            // convert to minutes
            int currMinutes = currH * 60 + currM;
            int prevMinutes = prevH * 60 + prevM;

            minAbsDiffMinutes = Math.min(minAbsDiffMinutes, currMinutes - prevMinutes);
        }

        int first = Integer.parseInt(timePoints.get(0).substring(0, 2)) * 60 + Integer.parseInt(timePoints.get(0).substring(3, 5));

        int lastIdx = timePoints.size()-1;
        int last = Integer.parseInt(timePoints.get(lastIdx).substring(0, 2)) * 60 + Integer.parseInt(timePoints.get(lastIdx).substring(3, 5));
        
        return Math.min(minAbsDiffMinutes, 24*60 - last + first);
    }
}
