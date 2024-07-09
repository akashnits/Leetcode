class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>( (a, b) -> 
        (aliceValues[b] + bobValues[b]) - (aliceValues[a] + bobValues[a]));

        int turn = 0;
        int n = aliceValues.length;

        for(int i=0; i < n ; i++){
            maxHeap.offer(i);
        }

        int aliceScore = 0, bobScore = 0;
        while(!maxHeap.isEmpty()){
            if(turn == 0){
                // alice's turn
                aliceScore += aliceValues[maxHeap.poll()];
            }else{
                // bob's turn
                bobScore += bobValues[maxHeap.poll()];
            }
            turn = turn == 0 ? 1: 0;
        }
        
        int diff = aliceScore - bobScore;
        if(diff == 0){
            return 0;
        }

        return diff > 0 ? 1: -1;
    }
}
