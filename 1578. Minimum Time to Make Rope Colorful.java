class Solution {
    // Approach: figure out the group of same colour balloons
    // greedily, remove the balloon with lower time and keep with higher time
    public int minCost(String colors, int[] neededTime) {
        char[] colorArray = colors.toCharArray();
        int res = 0;
        int n= neededTime.length;
        for(int start=0; start < n; ){
            int end = start+1;
            int maxValue = neededTime[start];
            while(end < n && colorArray[start] == colorArray[end]){
                // discard the one with lesser value
                res += Math.min(maxValue, neededTime[end]);
                // keep the one with higher value
                maxValue = Math.max(maxValue, neededTime[end]);
                end++; // expand
            }
            start = end;
        }
        return res;
    }
}
