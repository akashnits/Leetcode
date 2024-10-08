class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;

        int[] og = new int[n];
        for(int i=0; i < n; i++){
            og[i] = arr[i];
        }

        Arrays.sort(arr);

        int rank = 1;
        Map<Integer, Integer> eleToRankMap = new HashMap();
        for(int ele: arr){
            // assign rank if not mapped
            if(!eleToRankMap.containsKey(ele)){
                eleToRankMap.put(ele, rank++);
            }
        }

        int[] res = new int[n];
        for(int i=0; i < n; i++){
            res[i] = eleToRankMap.get(og[i]);
        }
        return res;
    }
}
