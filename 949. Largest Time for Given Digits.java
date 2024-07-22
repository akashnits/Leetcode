class Solution {
    String latestTime = "";
    public String largestTimeFromDigits(int[] arr) {
        // approach find all permutations
        // find valid ones
        // find max in valid ones
        int n = arr.length;

        // step 1: find all permitation - backtracking
        Map<Integer, Integer> map = new HashMap();
        // num -> freq
        for(int a: arr){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        findAllPermutations(map, new StringBuilder());
        return latestTime;
    }


    void findAllPermutations(Map<Integer, Integer> map, StringBuilder op){
        // repetition not allowed, permutaion allowed
        if(op.length() == 4){
            String hourStr = op.substring(0, 2);
            String minuteStr = op.substring(2);
            // don't use it if invalid
            int hours = Integer.parseInt(hourStr);
            int minutes = Integer.parseInt(minuteStr);

            if(!(hours < 0 || hours > 23 || minutes < 0 || minutes > 59)){
                // valid entry - find max
                String currentTime = hourStr + ":" + minuteStr;
                if (latestTime.compareTo(currentTime) < 0) {
                    latestTime = currentTime;
                }
                return;
            }
        }

        // choices
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int digit = entry.getKey();
            int freq = entry.getValue();

            if(freq == 0){
                continue;
            }

            // use this digit
            op.append(digit);
            // reduce count
            map.put(digit, freq -1);
            // recurse
            findAllPermutations(map, op);
            // undo
            map.put(digit, freq);
            op.deleteCharAt(op.length()-1);
        }
    }

}
