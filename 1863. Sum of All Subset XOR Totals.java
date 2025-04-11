class Solution {
    // Approach:
    // Number of subsets for a array containing N numbers - 2 ^ N
    // each number in the array is present in exactly half of the subsets i.e. 2 ^ N / 2 -> 2 ^ (N-1)

    // Since we want to calculate XOR sum of all subsets
    // we know that only set bit would contribute to the XOR sum
    // since each bit appears 2 ^ (N -1) times ( half of the subsets ), we could figure out the set bit first 
    // and multiple by 2 ^ (N -1)

    // figure out set bits by bitwise OR 
    // multiply by 2 ^ (N-1) to get result i.e. left shift the bitwise OR by 2 ^ (N-1)

    public int subsetXORSum(int[] nums) {
        int result = 0;
        // Capture each bit that is set in any of the elements
        for (int num : nums) {
            result |= num;
        }
        // Multiply by the number of subset XOR totals that will have each bit set
        return result << (nums.length - 1);
    }
}
