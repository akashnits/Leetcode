class Solution {
    int[][] dirMovements = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int robotSim(int[] commands, int[][] obstacles) {
        int n = commands.length;

        // Create set of obstacles
        Set<String> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] + "_" + obstacle[1]);
        }

        int[] currCoords = new int[]{0, 0};
        int maxDistance = 0;

        int currDirIdx = 0;  // Start facing north (dirs[0])

        for (int command : commands) {
            if (command == -1) {
                // dir change
                currDirIdx = (currDirIdx + 1) % 4;  // Turn right
            } else if (command == -2) {
                // dir change
                currDirIdx = (currDirIdx -1 + 4) % 4;  // Turn left (equivalent to -1 mod 4)
            } else {
                // this is actual movement
                int[] movement = dirMovements[currDirIdx];
                int distance = command;
                while (distance-- > 0) {
                    int nextX = currCoords[0] + movement[0];
                    int nextY = currCoords[1] + movement[1];
                    if (set.contains(nextX + "_" + nextY)) {
                        break;  // Obstacle encountered
                    }
                    currCoords[0] = nextX;
                    currCoords[1] = nextY;
                    maxDistance = Math.max(maxDistance, currCoords[0] * currCoords[0] + currCoords[1] * currCoords[1]);
                }
            }
        }

        return maxDistance;
    }
}
