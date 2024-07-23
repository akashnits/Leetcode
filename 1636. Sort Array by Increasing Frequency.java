import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        Integer[] boxedNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        // Custom comparator to sort by frequency, then by value descending
        Arrays.sort(boxedNums, (a, b) -> {
            if (frequencyMap.get(a) == (frequencyMap.get(b))) {
                return Integer.compare(b, a); // If frequencies are equal, sort by value descending
            }
            return Integer.compare(frequencyMap.get(a), frequencyMap.get(b)); // Sort by frequency ascending
        });
        
        return Arrays.stream(boxedNums).mapToInt(Integer::intValue).toArray();
    }
}
