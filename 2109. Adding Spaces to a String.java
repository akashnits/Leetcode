class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();

        int startIdx = 0;
        for(int i=0; i < spaces.length; i++){
            int endIdx = spaces[i];
            sb.append(s.substring(startIdx, endIdx));
            sb.append(" ");
            startIdx = endIdx;
        }

        sb.append(s.substring(startIdx));
        return sb.toString();
    }
}
