class Solution {
    int[][] dirs = { { 2, 1 }, { -2, 1 }, { 2, -1 }, { -2, -1 }, { 1, 2 }, { -1, 2 }, { 1, -2 }, { -1, -2 } };

    /*
        Constraints:
    
    -300 <= x, y <= 300
    0 <= |x| + |y| <= 300
    */

    public int minKnightMoves(int x, int y) {
        boolean[][] visited = new boolean[607][607];
        return minStepsBfs(x, y, visited);
    }

    int minStepsBfs(int x, int y, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList();
        int[] src = { 0, 0 };
        queue.add(src);

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] polled = queue.poll();
                int r = polled[0];
                int c = polled[1];

                // check if this is target
                if (x == r && y == c)
                    return steps;

                // add all unvisited cells which comes next
                for (int[] dir : dirs) {
                    int newR = r + dir[0];
                    int newC = c + dir[1];

                    // check if unvisited
                    if (visited[newR+302][newC+302])
                        continue;

                    queue.offer(new int[] { newR, newC });
                    // mark visited
                    visited[newR+302][newC+302] = true;
                }
            }
            steps++;
        }
        return steps;
    }
}
