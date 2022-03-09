// Recursive approach
class Solution {
    public int maxProfit(int k, int[] prices) {
        return solve(prices, 0, k, 0);
    }
    
    private int solve(int[] prices, int day, int k, int hold){
        // base condition
        if( day == prices.length || k == 0){
            return 0;
        }
        
        // choice diagram
        // we may sell if we hold a stock i.e. hold == 1
        if( hold == 1){
            return Math.max(prices[day] + solve(prices, day+1, k-1, 0) ,
                           solve(prices, day+1, k, hold));
        }else{
            // we may buy if hold == 0
            return Math.max(-prices[day] + solve(prices, day+1, k, 1), 
                           solve(prices, day+1, k, hold));
        }
    }
}
