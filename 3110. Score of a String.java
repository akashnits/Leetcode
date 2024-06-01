class Solution {
    public int scoreOfString(String s) {
        int sum =0;
        int n = s.length();
        for(int i=0; i < n-1; i++){
            sum += Math.abs(s.charAt(i+1) - (s.charAt(i)));
        }
        return sum;
    }
}
