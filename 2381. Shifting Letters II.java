class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] preShift = new int[n + 1]; // Prefix sum array for shift values

        // Apply the shifts to the prefix sum array
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1] + 1; // End is exclusive
            int dir = shift[2] == 0 ? -1 : 1;

            preShift[start] += dir;
            preShift[end] -= dir;
        }

        // Compute the cumulative shifts
        for (int i = 1; i < n; i++) {
            preShift[i] += preShift[i - 1];
        }

        // Build the result string
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int shift = preShift[i] % 26; // Modulo 26 to handle wrap-around
            if (shift < 0) shift += 26; // Convert negative shifts to positive
            char newChar = (char) ((s.charAt(i) - 'a' + shift) % 26 + 'a');
            res.append(newChar);
        }

        return res.toString();
    }
}
