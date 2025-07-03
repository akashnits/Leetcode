class Solution {
    // at most once - no change or 1 change
    // abbcccc
    public int possibleStringCount(String word) {
        int consecutive = 1;
        char prevChar = ' ';
        int res = 0;
        for(char c: word.toCharArray()){
            if (prevChar == c){
                // extend
                consecutive++;
            }else{
                // check if consecutive > 1
                res += consecutive-1;
                // reset
                consecutive = 1;
                prevChar = c;
            }
        }

        res += consecutive > 1 ? consecutive: 1; // adding 1 to cover if we have no repeating chars
        return res;
    }
}
