class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet();

        // find elements which is present in both arrays
        Set<Integer> set1 = new HashSet();
        Set<Integer> set2 = new HashSet();

        int i=0, j =0;
        int n1= nums1.length, n2 = nums2.length;

        // put values in both the sets
        while(i < n1 || j < n2){
            if( i >= n1){
                //check nums2
                set2.add(nums2[j++]);
            }else if( j >= n2){
                // check nums1
                set1.add(nums1[i++]);
            }else{
                //check both
                set1.add(nums1[i++]);
                set2.add(nums2[j++]);
            }
        }

        // find interection of both sets
        if(set1.size() >= set2.size()){
            // loop over set1
            for(int val1: set1){
                if(set2.contains(val1)){
                    set.add(val1);
                }
            }
        }else{
            for(int val2: set2){
                if(set1.contains(val2)){
                    set.add(val2);
                }
            }
        }

        // convert to array
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}
