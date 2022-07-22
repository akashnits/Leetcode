class Solution {
    public List<Integer> nums;
    
    public boolean makesquare(int[] matchsticks) {
        // reverse sort matchsticks
        nums = Arrays.stream(matchsticks).boxed().collect(Collectors.toList());
        Collections.sort(this.nums, Collections.reverseOrder());        
        int perimeter = 0;
        
        for(int matchstick: matchsticks){
            perimeter += matchstick;
        }
        
        if( perimeter % 4 != 0 ){
            // can't make square for sure
            return false;
        }
        
        return canMakeSquare(nums, 0, 4, perimeter/4, new int[4]);
    }
    
    
    public boolean canMakeSquare(List<Integer> matchsticks, int i, int k, int sideLength, int[] currLength){
        
        
        if(k == 0){
            return true;
        }
        
        // choices - each matchstick has 4 sides to go to
        for(int side=0; side < 4; side++){
            // check if side length is smaller than currLength + matchStick[i]
            if(currLength[side]+ matchsticks.get(i) <= sideLength){
                // we can place this matchstick and recurse on our decision
                currLength[side] += matchsticks.get(i);
                if(currLength[side] == sideLength) --k;
                if(canMakeSquare(matchsticks, i+1, k, sideLength, currLength)){
                    return true;
                }
                if(currLength[side] == sideLength) ++k;
                // we undo it
                currLength[side] -= matchsticks.get(i);
            }
        }
        
       return false;
    }
}
