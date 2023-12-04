class Solution {
    public String largestGoodInteger(String num) {
        // window size - 3
        // maintain a set containing elements in window

        Map<Character, Integer> windowMap = new HashMap();
        
        int start =0;
        int end = 0;

        int maxValue = Integer.MIN_VALUE;
        String res = "";

        while(end < num.length()){
            char ch = num.charAt(end);
            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);

            if(end - start + 1 == 3){ // window size is 3 now
                // valid substring, check if it contains unique chars
                if(windowMap.size() == 1){
                    // valid string
                    if(Integer.parseInt(num.substring(start, end+1)) > maxValue){
                        res = num.substring(start, end+1);
                        maxValue = Integer.parseInt(num.substring(start, end+1));
                    }
                }
                // shrink window
                char startCh = num.charAt(start);
                windowMap.put(startCh, windowMap.get(startCh) - 1);
                if(windowMap.get(startCh) == 0){
                    windowMap.remove(startCh);
                }
                start++;
            }
            // expand here
            end++;
        }

        return res;
    }
}
