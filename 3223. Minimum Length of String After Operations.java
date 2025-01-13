class Solution {
    // abaacbcbb -> acbcb
    public int minimumLength(String s) {
        // we need find group containing 3 same chars and reduce to 1
        // i.e. (count / 3 + count % 3)

        int[] freq = new int[26];
        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }

        int res = 0;
        for(int i =0; i < 26; i++){
            int count = freq[i];
            while(count > 2){
                // group and reduce
                count = count / 3 + count % 3;
            }
            res += count;
        }

        return res;
    }
}
