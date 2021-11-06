class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums1){
            int freq = map.getOrDefault(i, 0);
            map.put(i, freq + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : nums2){
            if(map.get(i) != null && map.get(i) > 0){
                list.add(i);
                map.put(i, map.get(i) - 1);
            }
        }
        //follow-up question - if arrays are sorted
//         Arrays.sort(nums1);
//         Arrays.sort(nums2);
//         List<Integer> resultList = new ArrayList();
        
//         // use two pointer to keep track
//         int i=0; 
//         int j=0;
        
//         while(i < nums1.length && j < nums2.length ){
//             if(nums1[i] == nums2[j]){
//                 //add to result and increment i & j
//                 resultList.add(nums1[i]);
//                 i++;
//                 j++;
//             }else if(nums1[i] < nums2[j]){
//                 i++;
//             }else{
//                 j++;
//             }
//         }
        
        int[] result = new int[list.size()];
        for(int k=0; k< list.size(); k++){
            result[k] = list.get(k);
        }
        
        return result;
    }
}
