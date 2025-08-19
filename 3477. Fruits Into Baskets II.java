class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count = 0;
        int n = baskets.length;
        for (int fruit : fruits) {
            int unplaced = 1;
            for (int i = 0; i < n; i++) {
                // finding the basket from left to right
                if (fruit <= baskets[i]) {
                    baskets[i] = 0;
                    unplaced = 0;
                    break;
                }
            }
            count += unplaced;
        }
        return count;
    }
}
