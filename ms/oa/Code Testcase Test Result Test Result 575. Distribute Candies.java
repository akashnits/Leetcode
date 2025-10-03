class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet();
        for(int candyT: candyType){
            set.add(candyT);
        }
        
        int totalTypes = set.size();
        int candyAliceCanEat = candyType.length / 2;
        
        return Math.min(totalTypes, candyAliceCanEat);
    }
}
