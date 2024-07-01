class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int oddStreak = 0;
        int i=0;
        int n = arr.length;

        while(i < n && oddStreak != 3){
            if(arr[i] % 2 == 1){
                oddStreak++;
            }else{
                oddStreak = 0;
            }
            i++;
        }

        return oddStreak == 3;
    }
}
