class Solution {
    public int minOperations(int[] nums) {
        // create a freqency map
        Map<Integer, Integer> freqMap = new HashMap();

        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // itearate over map and calculate min operations
        int minOps = 0;
        for(Map.Entry<Integer, Integer> entry: freqMap.entrySet()){
            int freq = entry.getValue();
            if(freq == 1){
                return -1;
            }

            minOps += Math.ceil((double) freq/3);
        }
        return minOps;
    }
}
