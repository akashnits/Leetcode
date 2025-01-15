class Solution {
    public int minimizeXor(int num1, int num2) {
        // Count bits in num2
        int ones = 0;
        while (num2 != 0) {
            ones++;
            num2 &= (num2 - 1); // Clear the least significant set bit
        }

        // x would have `ones` number of bits set
        // x XOR num1 to be minimum
        // Try placing 1 at the same place as num1 from left to right

        int count = 0;
        int x = 0;

        // Place ones from most significant positions of num1
        for (int i = 31; i >= 0 && ones > 0; i--) {
            if ((num1 & (1 << i)) != 0) { // Check if the i-th bit in num1 is set
                x |= (1 << i); // Set the i-th bit in x
                ones--; // Reduce the number of required set bits
            }
        }

        // If there are still remaining ones, place them in the least significant bits
        for (int i = 0; i <= 31 && ones > 0; i++) {
            if ((x & (1 << i)) == 0) { // If the i-th bit in x is not set
                x |= (1 << i); // Set the i-th bit in x
                ones--; // Reduce the number of required set bits
            }
        }

        return x;
    }
}
