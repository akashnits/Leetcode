class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        // sliding window
        int maxLength =0;
        int start =0, end =0;
        int n = s.length();
        int totalCost = 0;

        while(end < n){
            char c1= s.charAt(end);
            char c2= t.charAt(end);

            // try including this in substring
            totalCost += Math.abs(c1-c2);

            //check if this window is invalid, make it valid again
            while(start < n && totalCost > maxCost){
                // shrink at start
                totalCost -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }

            // valid window, record length
            if(totalCost <= maxCost){
                // valid substring, record it's length
                maxLength = Math.max(maxLength, end-start+1);
            }
            end++;
        }
        return maxLength;
    }
}
