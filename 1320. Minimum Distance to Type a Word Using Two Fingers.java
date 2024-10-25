import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<String, Integer> memo;

    public int minimumDistance(String word) {
        memo = new HashMap<>();
        return minDistance(word, 0, -1, -1); // Initial positions of fingers are undefined (-1)
    }

    private int minDistance(String word, int idx, int finger1, int finger2) {
        // Base case: If all characters are typed
        if (idx == word.length()) {
            return 0;
        }

        // Create a unique key for memoization
        String key = idx + "," + finger1 + "," + finger2;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Current character position
        int[] currentPos = calculatePos(word.charAt(idx));
        int distance1 = (finger1 == -1) ? 0 : manhattanDistance(calculatePos((char) ('A' + finger1)), currentPos);
        int distance2 = (finger2 == -1) ? 0 : manhattanDistance(calculatePos((char) ('A' + finger2)), currentPos);

        // Move finger 1 or finger 2
        int moveFinger1 = distance1 + minDistance(word, idx + 1, word.charAt(idx) - 'A', finger2);
        int moveFinger2 = distance2 + minDistance(word, idx + 1, finger1, word.charAt(idx) - 'A');

        // Get the minimum distance
        int result = Math.min(moveFinger1, moveFinger2);
        memo.put(key, result); // Store in memoization map

        return result;
    }

    private int manhattanDistance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    private int[] calculatePos(char c) {
        int linearDist = c - 'A';
        int row = linearDist / 6;
        int col = linearDist % 6;
        return new int[]{row, col};
    }
}
