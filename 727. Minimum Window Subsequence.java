class Solution {
    // find min length substring in s1 such that s2 is it's subsequence ( order matter )
    // taking two pointer approach - do forward scan to find end and backward scan to find start
    // keep doing this - resetting start to start +1 after the loop
    public String minWindow(String s1, String s2) {
        int i = 0; // pointer for s1
        int j = 0; // pointer for s2

        int n = s1.length();
        int start = 0;
        int end = start;

        int minWindowLen = Integer.MAX_VALUE;
        String res= "";

        while(start < n){
            i = start;
            j = 0;


            while(i < n && j < s2.length()){
                // forward scan -> scans s1 from i until end is decided i.e. all letters from s2 are found
                if(s1.charAt(i) == s2.charAt(j)){
                    j++;
                }
                i++;
            }

            if(j != s2.length())
                break; // we couldn't find all s2 chars

            end = i-1; // end is decided if all s2 chars found
            j = s2.length()-1;
            i = end;

            // backward scan to find start
            while(i >= 0 && j >= 0){
                if(s1.charAt(i) == s2.charAt(j)){
                    j--;
                }
                i--;
            }

            if(j != -1)
                break; // this isn;t really required
            start = i+1;

            // this is a valid window if start and end are valid
            if(end -start+1 < minWindowLen){
                minWindowLen = end - start + 1;
                res = s1.substring(start, end+1);
            }
            // start from next start+1
            start++;
        }
        return res;
    }
}
