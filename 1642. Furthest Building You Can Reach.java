class Solution {
    // Approach: Greedy - use ladders until available to climb
    // keep track of heights climbed - minHeap
    // now , we have no more ladders - we need to use bricks to go further
    // bricks required < minHeap.peek() - height climbed by ladder is greater -> if have bricks, use it to climb
    // else - height climbed by ladder is smaller or equal , use ladder to climb next , brick for minHeap.peek() height
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // create a minHeap to keep track of heights climbed by ladder
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        int n = heights.length;
        int i = 1;
        while(i < n){
            int heightToClimb = heights[i] - heights[i-1];
            if(heightToClimb <= 0){
                //no need of ladder or brick
                i++;
                continue;
            }else{
                // we need either brick or ladder
                // if we have ladder , use it
                if(ladders > 0){
                    minHeap.offer(heightToClimb); // climbed this height by ladder
                    ladders--;
                }else{
                    // we only have bricks
                    int lowestHeightClimbedByLadder  = Integer.MAX_VALUE;
                    if(!minHeap.isEmpty()){
                        lowestHeightClimbedByLadder = minHeap.peek();
                    }
                    if(heightToClimb < lowestHeightClimbedByLadder){
                        // use bricks if you have 
                        if(bricks >= heightToClimb){
                            bricks -= heightToClimb;
                        }else{
                            //not enough bricks, return
                            return i-1;
                        }
                    }else{
                        // we want to use ladder for this climb
                        // bricks should be used of climb which is top of minHeap
                        if(bricks >= lowestHeightClimbedByLadder){
                            bricks -= lowestHeightClimbedByLadder;
                            minHeap.poll(); // this was climbed by bricks
                            minHeap.offer(heightToClimb); // this was climbed by ladder
                        }else{
                            // can't climb 
                            return i-1;
                        }
                    }
                }
            }
            i++;
        }
        return i-1;
    }
}
