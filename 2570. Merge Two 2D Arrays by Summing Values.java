class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int idx1 = 0;
        int idx2 = 0;

        int n1= nums1.length;
        int n2= nums2.length;

        List<int[]> res = new ArrayList();

        while(idx1 < n1 && idx2 < n2){
            // case 1: both idx1 and idx2 - id is same
            int[] combinedInterval = new int[2];
            if(nums1[idx1][0] == nums2[idx2][0]){
                // combine and add
                combinedInterval[0] = nums1[idx1][0];
                combinedInterval[1] = nums1[idx1][1] + nums2[idx2][1];
                idx1++;
                idx2++;
            }else if(nums1[idx1][0] < nums2[idx2][0]){
                // idx1 is smaller
                combinedInterval= nums1[idx1];
                idx1++;
            }else{
                // idx2 is smaller
                combinedInterval= nums2[idx2];
                idx2++;
            }
            res.add(combinedInterval);
        }

        // check remaining idx1 and idx2 values
        while(idx1 < n1){
            res.add(nums1[idx1]);
            idx1++;
        }

        while(idx2 < n2){
            res.add(nums2[idx2]);
            idx2++;
        }

        return res.toArray(new int[0][]);
    }
}
