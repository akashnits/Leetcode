class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freqMap = new HashMap();
        int n1 = nums1.length;
        int n2 = nums2.length;

        int res = 0;
        for(int val1: nums1){
            // val1 appears n2 times
            if(n2 % 2 == 1){
                res ^= val1;
            }else{
                break;
            }
        }

        for(int val2: nums2){
            if(n1 % 2 == 1){
                res ^= val2;
            }else{
                break;
            }
        }

        return res;
    }
}
