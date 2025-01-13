class Solution {
    public boolean canConstruct(String s, int k) {
        // edge case
        if (s.length() < k) return false;
        int[] freqMap = new int[26];
        for(char c: s.toCharArray()){
            freqMap[c-'a']++;
        }

        int oddCount = 0;
        // even length reduced to 0
        for(int freq: freqMap){
            if(freq % 2 == 1){
                oddCount++;
            }
        }
        return (oddCount) <= k;
    }
}
