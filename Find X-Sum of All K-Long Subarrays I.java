public class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        // Map to store the frequency of elements
        Map<Integer, Integer> freqMap = new HashMap<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];  // Result array to store the sums
        int start = 0;
        int end = 0;
        
        while (end < n) {
            // Add current element to frequency map
            int currElement = nums[end];
            freqMap.put(currElement, freqMap.getOrDefault(currElement, 0) + 1);
            
            // Check if window size is k
            if (end - start + 1 == k) {
                // Create a list from the frequency map and sort it based on frequencies
                List<Integer> freqList = new ArrayList<>(freqMap.keySet());
                
                // Sort the list by frequency first, and by element value if frequencies are the same
                freqList.sort((a, b) -> {
                    if (freqMap.get(b) == freqMap.get(a)) {
                        return (b - a);  
                    }
                    return freqMap.get(b) - freqMap.get(a);  
                });
                
                // Calculate the sum of the top x most frequent elements
                int sum = 0;
                for (int i = 0; i < Math.min(x, freqList.size()); i++) {
                    sum += freqList.get(i) * freqMap.get(freqList.get(i));
                }
                res[start] = sum;
                
                // Shrink the window by removing the start element from the frequency map
                int outgoingElement = nums[start];
                freqMap.put(outgoingElement, freqMap.get(outgoingElement) - 1);
                if (freqMap.get(outgoingElement) == 0) {
                    freqMap.remove(outgoingElement);
                }
                
                start++;
            }
            end++;
        }
        
        return res;
    }
}
