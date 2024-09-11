class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        // m represents the number of given rolls
        int m = rolls.length;

        int totalSumRequired = (n + m) * mean;

        // Subtract the sum of given rolls from the total sum required
        // to find the sum needed from the missing rolls
        for (int rollValue : rolls) {
            totalSumRequired -= rollValue;
        }

        // If the total sum needed is impossible (either too low or too high given the constraints),
        // return an empty array
        if (totalSumRequired > n * 6 || totalSumRequired < n) {
            return new int[0];
        }

        // Initialize the array to hold the missing rolls
        int[] missingRolls = new int[n];

        // Fill the missing rolls array distributing evenly
        Arrays.fill(missingRolls, totalSumRequired / n);

        // Distribute the remainder of the sum needed evenly across the first
        // 'totalSumRequired % n' elements by adding one to each
        for (int i = 0; i < totalSumRequired % n; i++) {
            missingRolls[i]++;
        }

        // Return the missing rolls array
        return missingRolls;
    }
}
