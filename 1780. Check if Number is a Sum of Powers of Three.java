class Solution {
    // we need to write n in the form 3 ^ 0 + 3 ^ 1 + ... 3 ^ x.. + 3 ^ 16

    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}
