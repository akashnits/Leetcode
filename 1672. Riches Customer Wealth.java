class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for(int[] row: accounts){
            int money = 0;
            for(int i=0; i < row.length; i++){
                money += row[i];
            }
            max = Math.max(max, money);
        }
        return max;
    }
}
