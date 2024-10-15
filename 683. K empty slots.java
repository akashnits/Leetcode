class Solution {
    // approach: keep track of indices of switched on bulbs
    // number of switched off bulbs shoule be exactly k between switched on bulbs
    public int kEmptySlots(int[] bulbs, int k) {
        TreeSet<Integer> treeSet = new TreeSet();
        int day = 0;

        for(int bulb: bulbs){
            int idx = bulb - 1; // bulb at idx is switched on at this day
            treeSet.add(idx);
            day++;

            // check switched off bulbs to the left and right of this bulb
            Integer lower = treeSet.lower(idx);
            Integer higher = treeSet.higher(idx);

            if(lower != null && idx - lower == k+1 || higher != null && higher - idx == k+1){
                return day;
            }
        }
        return -1;
    }
}
