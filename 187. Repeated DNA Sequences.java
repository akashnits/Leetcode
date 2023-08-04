class Solution {
    // approach: fix size window - all windows of length 10 is valid
    // we slide the window on every step and keep a count
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap();
        List<String> res = new ArrayList();

        int n = s.length();

        // can't find repetition below count - 11
        if(n < 11){
            return res;
        }

        int start = 0;
        int end = 9;

        StringBuilder windowsSb = new StringBuilder(s.substring(start, end));
        String windowStr;
        while(end < n){
            windowsSb.append(s.charAt(end));
            windowStr = windowsSb.toString();
            map.put(windowStr, map.getOrDefault(windowStr, 0) + 1);
            if(map.get(windowStr) == 2){ // repeated
                res.add(windowStr);
            }

            // shrink to drop the first char 
            windowsSb.deleteCharAt(0);
            // expand here to get last char
            end++;
        }

        return res;
    }
}
