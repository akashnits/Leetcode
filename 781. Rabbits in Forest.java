class Solution {
    public int numRabbits(int[] answers) {
        // take greedy approach
        // when a rabbit says it has m rabbits of same color, means there is a group of size m+1
        int n = answers.length;
        int totalRabbits = 0;
        // capacity -> seats available
        Map<Integer, Integer> map = new HashMap();

        for(int i=0; i < n; i++){
            int groupSize = answers[i] + 1;
            // check in the map if this groupSize exists
            if(map.containsKey(groupSize)){
                // put this rabbit in this group
                map.put(groupSize, map.get(groupSize)-1);
            }else{
                // put a new entry (groupSize, groupSize-1)
                map.put(groupSize, groupSize-1);
            }

            // check if no seats available in the group
            if(map.get(groupSize) == 0){
                totalRabbits += groupSize; // group full of rabbits
                // drop it
                map.remove(groupSize);
            }
        }

        // loop over map keyset and add
        for(int capacity: map.keySet()){
            totalRabbits += capacity;
        }

        return totalRabbits;
    }
}
