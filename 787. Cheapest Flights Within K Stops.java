import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int cost = flight[2];

            if (!adj.containsKey(u)) {
                adj.put(u, new ArrayList<>());
            }
            adj.get(u).add(new int[]{v, cost});
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});
        distance[src] = 0;

        int level = 0;

        while (!queue.isEmpty() && level <= k) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int u = current[0];
                int costU = current[1];

                List<int[]> neighbors = adj.getOrDefault(u, new ArrayList<>());
                for (int[] neighbor : neighbors) {
                    int v = neighbor[0];
                    int costUV = neighbor[1];

                    if (distance[v] > costU + costUV) {
                        distance[v] = costU + costUV;
                        queue.offer(new int[]{v, distance[v]});
                    }
                }
            }
            level++;
        }

        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
}
