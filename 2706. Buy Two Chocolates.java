class Solution {
    // find first and sencond min
    public int buyChoco(int[] prices, int money) {
        int firstMin;
        int secondMin;

        if(prices[0] >= prices[1]){
            firstMin = prices[1];
            secondMin = prices[0];
        }else{
            firstMin = prices[0];
            secondMin = prices[1];
        }

        for(int i=2; i < prices.length; i++){
            // case 1: prices[i] smaller than both - update both
            // case 2: prices[i] greater than both - do nothing
            // case 3: prices[i] in b/w - update only one

            if(prices[i] < firstMin && prices[i] < secondMin){
                secondMin = firstMin;
                firstMin = prices[i];
            } else if(prices[i] < secondMin) {
                secondMin = prices[i];
            }
        }

        int sum= firstMin + secondMin;
        return sum > money ? money: money-sum;
    }
}
