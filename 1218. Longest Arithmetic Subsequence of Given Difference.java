class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int res = 1;
        // element to subsequence length
        Map<Integer, Integer> map = new HashMap();

        // loop through the array
        // arr[i]-diff : look for this in the map
        // case 1: it doesn't exist - (arr[i], 1)
        // case 2: it exists, (arr[i], map.get(arr[i]-diff) + 1)

        for(int i=0; i < arr.length; i++){
            int subLengthBefore = map.getOrDefault(arr[i]-difference, 0);
            map.put(arr[i], subLengthBefore+1);
            res = Math.max(res, map.get(arr[i]));
        }

        return res;

    }
}
