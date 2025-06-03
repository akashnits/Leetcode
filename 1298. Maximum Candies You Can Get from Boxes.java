class Solution {
    int[] visitedBox;

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        Set<Integer> keySet = new HashSet<>();
        Set<Integer> boxSet = new HashSet<>();
        visitedBox = new int[n];
        int res = 0;
        for (int box : initialBoxes) {
            boxSet.add(box);
        }
        for (int box : initialBoxes) {
            res += openBox(status, candies, keys, containedBoxes, boxSet, keySet, box);
        }
        return res;
    }

    int openBox(int[] status, int[] candies, int[][] keys, int[][] containedBoxes,
                Set<Integer> boxSet, Set<Integer> keySet, int boxIdx) {
        if (visitedBox[boxIdx] == 1) {
            return 0;
        }

        // If box is closed and you don't have the key, can't open
        if (status[boxIdx] == 0 && !keySet.contains(boxIdx)) {
            return 0;
        }

        visitedBox[boxIdx] = 1;
        int countCandies = candies[boxIdx];

        // Collect keys from this box and add them to keySet
        int[] newKeysFound = getKeys(keys, boxIdx);
        for (int key : newKeysFound) {
            if (!keySet.contains(key)) {
                keySet.add(key);
                // If you got the key to a box you already have, try to open it now
                if (boxSet.contains(key) && visitedBox[key] == 0) {
                    countCandies += openBox(status, candies, keys, containedBoxes, boxSet, keySet, key);
                }
            }
        }

        // Collect boxes contained inside this box
        int[] newBoxesFound = getBoxes(containedBoxes, boxIdx);
        for (int box : newBoxesFound) {
            if (!boxSet.contains(box)) {
                boxSet.add(box);
            }
            if (visitedBox[box] == 0) {
                // Open if box is open or if you have the key
                if (status[box] == 1 || keySet.contains(box)) {
                    countCandies += openBox(status, candies, keys, containedBoxes, boxSet, keySet, box);
                }
            }
        }

        return countCandies;
    }

    int[] getKeys(int[][] keys, int idx) {
        return keys[idx];
    }

    int[] getBoxes(int[][] containedBoxes, int idx) {
        return containedBoxes[idx];
    }
}
