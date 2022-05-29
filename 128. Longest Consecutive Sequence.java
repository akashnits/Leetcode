class Solution {
    
    Set<Integer> numSet;
    public int longestConsecutive(int[] nums) {
        numSet = new HashSet();
        for(int num: nums){
            numSet.add(num);
        }
        
        int longestStreak = 0;
        for(int num: nums){
            if(numSet.contains(num+1)){
                // we anyway are gonna calculate and include in lcs
                continue;
            }
            longestStreak = Math.max(longestStreak, countConsecEndAt(num, 1));
        }
        return longestStreak;
    }
    
    
    private int countConsecEndAt(int num, int count){
        
        if(!numSet.contains(num-1)){
            return count;
        }
        
        return countConsecEndAt(num-1, count+1);
    }
}
