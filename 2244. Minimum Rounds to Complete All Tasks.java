class Solution {
    public int minimumRounds(int[] tasks) {
        // create a freqency map
        Map<Integer, Integer> freqMap = new HashMap();

        for(int task: tasks){
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        }

        // itearate over map and calculate min rounds
        int minRounds = 0;
        for(Map.Entry<Integer, Integer> entry: freqMap.entrySet()){
            int freq = entry.getValue();
            if(freq == 1){
                return -1;
            }

            minRounds += Math.ceil((double) freq/3);
        }
        return minRounds;
    }
}
