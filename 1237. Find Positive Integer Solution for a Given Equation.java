/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */

class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> result = new ArrayList<>();
        int x = 1;
        int y = 1000;  // assuming y is initially large enough

        while (x <= 1000 && y >= 1) {
            int val = customfunction.f(x, y);
            if (val == z) {
                // we found a pair
                List<Integer> pair = new ArrayList();
                pair.add(x);
                pair.add(y);
                result.add(pair);
                x++;
                y--;  // move diagonally left-down
            } else if (val < z) {
                x++;  // move right
            } else {
                y--;  // move down
            }
        }

        return result;
    }
}
