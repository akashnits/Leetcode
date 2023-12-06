class Solution {
    public int totalMoney(int n) {
        int weeks = n /7;
        int remainingDays = n %7;

        // sum pf AP : S = n/2[2a + (n − 1) × d]
        double money =0;
        int i=0;
        while(i < weeks){
            money += 3.5 * ( 2 * (i+1) + 6 );
            i++;
        }

        // sum of remaining days
        money += (remainingDays/2.0) * ( 2 * (i+1) + (remainingDays -1));
        return (int) money;
    }
}
