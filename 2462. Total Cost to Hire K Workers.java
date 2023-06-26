class Solution {
    public long totalCost(int[] costs, int k, int candidates) {

        // total cost
        long totalCost = 0;

        // two pointers to keep track of left and right indices
        int l = -1;
        int r = costs.length;

        // create two min heaps
        PriorityQueue<Candidate> leftHeap = new PriorityQueue<Candidate>((a, b) -> (a.cost - b.cost));
        PriorityQueue<Candidate> rightHeap = new PriorityQueue<Candidate>((a, b) -> (a.cost - b.cost));

        // construct two heaps as per cost and keep the pointer updated
        for(int i=0; i < candidates; i++){
            leftHeap.add(new Candidate(i, costs[i]));
            l++;
        }

        for(int j=costs.length-1; j > (costs.length-1 - candidates); j--){
            if(j <= l){
                // break out of the loop
                break;
            }
            rightHeap.add(new Candidate(j, costs[j]));
            r--;
        }

        // lets compute the cost now, peek both the heaps and decide in polling 
        int hiringCost;
        for(int session=0; session < k; session++){
            hiringCost= 0;
            // look at the heaps
            if(rightHeap.size() == 0 || leftHeap.size() > 0 && leftHeap.peek().cost <= rightHeap.peek().cost){
                hiringCost = leftHeap.poll().cost;
                l++;
                if( l < r){
                    leftHeap.add(new Candidate(l, costs[l]));
                }
            }else if(rightHeap.size() > 0){
                hiringCost = rightHeap.poll().cost;
                r--;
                if( l < r){
                    rightHeap.add(new Candidate(r, costs[r]));
                }
            }
            totalCost += hiringCost;

        }
        return totalCost;
    }

    public class Candidate{
        int index; 
        int cost;
    
        Candidate(int index, int cost){
            this.index = index;
            this.cost = cost;
        }

    }
}
