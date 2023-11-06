class Solution {
    public int getWinner(int[] arr, int k) {
        int max =0;
        for(int ele: arr){
            max = Math.max(max, ele);
        }

        // conner case - if K >= arr.length
        if( k >= arr.length){
            // largest element is the winner
            return max;
        }

        int winCount =0;
        int currIdx=1;
        int winner = arr[0];
        while(winCount < k && currIdx < arr.length){
            // play a round
            if(winner > arr[currIdx]){
                // increment win count
                winCount++;
            }else{
                // new winner
                winner = arr[currIdx];
                winCount =1;
                
            }
            currIdx++;
        }
        return winner;
    }
}
