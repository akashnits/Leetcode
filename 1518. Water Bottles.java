class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int filledBottles = numBottles;
        int emptyBottles = 0;
        int res = 0;

        while(filledBottles > 0){
            // drink filledBottles to make it empty
            res += filledBottles;
            emptyBottles = emptyBottles + filledBottles;
            // we exhange and fill some of them to fill it
            filledBottles = emptyBottles / numExchange;
            emptyBottles = emptyBottles % numExchange;
        }
        return res;
    }
}
