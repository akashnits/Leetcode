import java.util.ArrayList;
import java.util.List;

// approach: idea is to iterate over neighbors and find out the types used by them
// type which isn't used bu neighbor is assigned to parent
public class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        // Initialize the adjacency list for the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Build the graph
        for (int[] path : paths) {
            int u = path[0] - 1;
            int v = path[1] - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        // Result array to store the flower types
        int[] result = new int[n];
        
        // Assign flower types to each garden
        for (int i = 0; i < n; i++) {
            // we have four types for neighbors
            boolean[] usedTypes = new boolean[5];  
            
            // Check the flower types of neighboring gardens
            for (int neighbor : graph.get(i)) {
                if (result[neighbor] != 0) {
                    // type is already used , making it unavailable
                    usedTypes[result[neighbor]] = true;
                }
            }
            
            // Assign the smallest available flower type to parent
            for (int flowerType = 1; flowerType <= 4; flowerType++) {
                if (!usedTypes[flowerType]) {
                    result[i] = flowerType;
                    break;
                }
            }
        }
        
        return result;
    }
}
