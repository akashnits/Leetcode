class Solution {
    String nextClosest = "";
    int minDiff = Integer.MAX_VALUE;
    int totalGivenMinutes;
    public String nextClosestTime(String time) {
        totalGivenMinutes = Integer.parseInt(time.substring(0, 2)) * 60 + 
                            Integer.parseInt(time.substring(3));
        Set<Character> set = new HashSet();
        for(char c: time.toCharArray()){
            if(c == ':') continue;
            set.add(c);
        }
        char[] timeArr = new char[set.size()];
        int idx = 0;
        for(char c: set){
            timeArr[idx] = c;
            idx++;
        }

        findAllPermutations(timeArr, "");
        return nextClosest;
    }

    void findAllPermutations(char[] timeArr, String op){
        // repetition is allowed, permutation is allowed
        // we have duplicates 
        if(op.length() == 4){
            String copy = new String(op);
            // check if it's valid
            String hourStr = copy.substring(0,2);
            String minuteStr = copy.substring(2);

            int currentHours = Integer.parseInt(hourStr);
            int currentMinutes = Integer.parseInt(minuteStr);
            if (currentHours > 23 || currentMinutes > 59) {
                return;
            }
            
            // Calculate the difference in minutes
            int totalCurrentMinutes = currentHours * 60 + currentMinutes;
            
            int diff = totalCurrentMinutes - totalGivenMinutes;
            if (diff <= 0) {
                diff += 24 * 60; // Add a day's worth of minutes to handle next day scenarios
            }

            // Update closest time if the current one is closer
            if (diff < minDiff) {
                minDiff = diff;
                nextClosest = hourStr + ":" + minuteStr;
            }
            return;
        }

        // choices
        for(int i=0; i < timeArr.length; i++){
            findAllPermutations(timeArr, op + timeArr[i]);
        }
    }
}
