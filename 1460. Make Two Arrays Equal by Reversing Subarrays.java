class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] freq = new int[10001];
        for(int ele: target){
            freq[ele]++;
        }

        for(int ele: arr){
            if(--freq[ele] < 0){
                return false;
            }
        }

        return true;
    }
}
