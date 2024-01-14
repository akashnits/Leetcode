class Solution {
    public int minSteps(String s, String t) {
        int[] freqArr = new int[26];

        for(int i=0; i < s.length(); i++){
            char c1= s.charAt(i);
            char c2= t.charAt(i);

            freqArr[c1-'a']++;
            freqArr[c2-'a']--;
        }

        int res =0;
        for(int i=0; i < 26; i++){
            res += Math.abs(freqArr[i]);
        }
        return res/2;
    }
}
