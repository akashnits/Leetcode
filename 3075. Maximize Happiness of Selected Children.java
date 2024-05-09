class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        // trying the greedy approach
        int n = happiness.length;
        Arrays.sort(happiness);
        // start from end to first
        int round = 0;
        long res =0;
        for(int i= n-1; i >=0 && k > 0; i--){
            int effHappiness = happiness[i] - round;
            if(effHappiness <= 0){
                break;
            }
            res += effHappiness;
            round++;
            k--;
        }
        return res;
    }
}
