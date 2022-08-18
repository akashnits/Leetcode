// Solution 1
class Solution {
    public int minSetSize(int[] arr) {
        // key -> element, value -> frequency
        Map<Integer, Integer> map = new HashMap();
        
        for(int ele: arr){
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        
        // sort the map based on frequency
        Map<Integer, Integer> sortedMap = sortByValue(map);
        
        int half = arr.length/2;
        int size = arr.length;
        
        Iterator<Map.Entry<Integer, Integer>> itr = sortedMap.entrySet().iterator();
        
        int res=0;
        while(itr.hasNext() && size > half){
            // we need to remove element with max frequency
            Map.Entry<Integer, Integer> entry = itr.next();
            size -= entry.getValue();
            itr.remove();
            res++;
        }
        
        return size <= half ? res: -1;
    }
    
    public static Map<Integer, Integer> sortByValue(Map<Integer, Integer> map) {
        List<Map.Entry<Integer, Integer>> list = new LinkedList(map.entrySet());

        Collections.sort(list, ((a, b) -> b.getValue() -a.getValue()) );

        Map<Integer, Integer> result = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}



// Runtime: 11 ms, faster than 99.78% of Java online submissions for Reduce Array Size to The Half.
// Solution 2
class Solution {
    // applying bucket sort approach
    public int minSetSize(int[] arr) {
        int size = arr.length;
        int half = size/2;
        int count =0;
        
        // freq[i] is the frequency for item having value i
        int[] freq = new int[100001];
        for(int i: arr){
            freq[i]++;
        }
        
        // create frequency buckets i.e. frequencyBucket[i] will contain the count of elements
        // having frequency i
        
        int[] freqBucket = new int[100001];
        
        for(int i=1; i < freq.length; i++){
            freqBucket[freq[i]]++;
        }
        
        // loop over freqBucket from end as we need to remove higher frequency elements first
        for(int j=freqBucket.length-1; j > 0 ; j--){
            while(freqBucket[j] > 0){
                if(size <= half){
                    return count;
                }
                size -=j;
                freqBucket[j]--;
                count++;
            }
        }
        return size <= half? count: -1;
    }
}
