class Solution {
    public int minIncrementForUnique(int[] nums) {
        // sort the array
        Arrays.sort(nums);
        // use a hashset to keep track of values
        Set<Integer> set = new HashSet();

        int moves = 0;
        int nextAvailable = 0;
        for(int num: nums){
            if(!set.contains(num)){
                // add to set, no need to increment
                set.add(num);
                nextAvailable = num+1;
            }else{
                if(nextAvailable > num){
                    // we can add nextAvailable to set
                    set.add(nextAvailable);
                    moves += nextAvailable - num;
                    nextAvailable = nextAvailable+1;
                }else{
                    set.add(num+1);
                    nextAvailable = num+2;
                    moves += 1;
                }
            }
        }

        return moves;
    }
}
