class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer, String> map = new TreeMap(Collections.reverseOrder());
        int n = names.length;

        for(int i=0; i < n; i++){
            map.put(heights[i], names[i]);
        }

        int idx =0;
        for(Map.Entry<Integer, String> entry: map.entrySet()){
            names[idx] = entry.getValue();
            idx++;
        }

        return names;
    }
}
